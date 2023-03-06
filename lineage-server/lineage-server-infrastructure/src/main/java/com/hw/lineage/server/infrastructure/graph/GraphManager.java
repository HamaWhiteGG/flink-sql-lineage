package com.hw.lineage.server.infrastructure.graph;

import com.hw.lineage.common.result.ColumnResult;
import com.hw.lineage.server.domain.entity.task.Task;
import com.hw.lineage.server.domain.entity.task.TaskLineage;
import com.hw.lineage.server.domain.facade.LineageFacade;
import com.hw.lineage.server.domain.graph.column.ColumnGraph;
import com.hw.lineage.server.domain.graph.table.TableGraph;
import com.hw.lineage.server.domain.graph.column.ColumnEdge;
import com.hw.lineage.server.domain.graph.table.TableEdge;
import com.hw.lineage.server.domain.graph.column.ColumnNode;
import com.hw.lineage.server.domain.graph.basic.Node;
import com.hw.lineage.server.domain.graph.table.TableNode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.hw.lineage.common.util.Constant.DELIMITER;


/**
 * @description: GraphManager
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class GraphManager {

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    private LineageFacade lineageFacade;

    private TableGraph tableGraph;

    private ColumnGraph columnGraph;

    public GraphManager(LineageFacade lineageFacade) {
        this.lineageFacade = lineageFacade;
        this.tableGraph = new TableGraph();
        this.columnGraph = new ColumnGraph();
    }

    public void createLineageGraph(String pluginCode, Task task) throws Exception {
        for (TaskLineage lineage : task.getTaskLineageList()) {
            Node sourceTableNode = getSourceTableNode(pluginCode, lineage);
            Node targetTableNode = getTargetTableNode(pluginCode, lineage);
            tableGraph.addEdge(new TableEdge(sourceTableNode, targetTableNode, lineage.getSqlId().getValue()));

            Node sourceColumnNode = columnGraph.getNode(lineage.buildSourceColumnName());
            Node targetColumnNode = columnGraph.getNode(lineage.buildTargetColumnName());
            columnGraph.addEdge(new ColumnEdge(sourceColumnNode, targetColumnNode, lineage.getTransform()));
        }
        task.setTableGraph(tableGraph);
        task.setColumnGraph(columnGraph);
    }

    public Node getSourceTableNode(String pluginCode, TaskLineage lineage) throws Exception {
        String sourceTableName = lineage.buildSourceTableName();
        TableNode sourceTableNode = (TableNode) tableGraph.getNode(sourceTableName);

        if (sourceTableNode == null) {
            Integer tableNodeId = atomicInteger.getAndIncrement();
            sourceTableNode = new TableNode(tableNodeId, sourceTableName);
            List<ColumnResult> columnList = lineageFacade.getTable(pluginCode, lineage.getSourceCatalog()
                    , lineage.getSourceDatabase(), lineage.getSourceTable()).getColumnList();

            for (ColumnResult column : columnList) {
                String nodeName = String.join(DELIMITER, sourceTableName, column.getColumnName());
                ColumnNode columnNode = new ColumnNode(atomicInteger.getAndIncrement(), column.getColumnName(), tableNodeId);
                columnGraph.putNode(nodeName, columnNode);
                sourceTableNode.addColumnNode(columnNode);
            }
            tableGraph.putNode(sourceTableName,sourceTableNode);
        }
        return sourceTableNode;
    }


    public Node getTargetTableNode(String pluginCode, TaskLineage lineage) throws Exception {
        String targetTableName = lineage.buildTargetTableName();
        TableNode targetTableNode = (TableNode) tableGraph.getNode(targetTableName);

        if (targetTableNode == null) {
            Integer tableNodeId = atomicInteger.getAndIncrement();
            targetTableNode = new TableNode(tableNodeId, targetTableName);
            List<ColumnResult> columnList = lineageFacade.getTable(pluginCode, lineage.getTargetCatalog()
                    , lineage.getTargetDatabase(), lineage.getTargetTable()).getColumnList();

            for (ColumnResult column : columnList) {
                String nodeName = String.join(DELIMITER, targetTableName, column.getColumnName());
                ColumnNode columnNode = new ColumnNode(atomicInteger.getAndIncrement(), column.getColumnName(), tableNodeId);
                columnGraph.putNode(nodeName, columnNode);
                targetTableNode.addColumnNode(columnNode);
            }
            tableGraph.putNode(targetTableName,targetTableNode);
        }
        return targetTableNode;
    }
}
