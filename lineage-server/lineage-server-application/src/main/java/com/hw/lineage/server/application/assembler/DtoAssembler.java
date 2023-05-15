/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.application.assembler;

import com.google.common.base.Strings;
import com.hw.lineage.server.application.dto.*;
import com.hw.lineage.server.application.dto.graph.LineageGraph;
import com.hw.lineage.server.application.dto.graph.link.ColumnLink;
import com.hw.lineage.server.application.dto.graph.link.TableLink;
import com.hw.lineage.server.application.dto.graph.link.basic.Link;
import com.hw.lineage.server.application.dto.graph.vertex.Column;
import com.hw.lineage.server.application.dto.graph.vertex.Vertex;
import com.hw.lineage.server.domain.entity.*;
import com.hw.lineage.server.domain.entity.task.Task;
import com.hw.lineage.server.domain.entity.task.TaskFunction;
import com.hw.lineage.server.domain.entity.task.TaskLineage;
import com.hw.lineage.server.domain.entity.task.TaskSql;
import com.hw.lineage.server.domain.graph.column.ColumnGraph;
import com.hw.lineage.server.domain.graph.table.TableGraph;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import static com.hw.lineage.common.util.Constant.DELIMITER;

/**
 * @description: TaskAssembler
 * @author: HamaWhite
 */
@Mapper(componentModel = "spring")
public interface DtoAssembler {
    DtoAssembler INSTANCE = Mappers.getMapper(DtoAssembler.class);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "catalogId.value", target = "catalogId")
    @Mapping(source = "taskSource.value", target = "taskSource")
    TaskDTO fromTask(Task task);

    @Mapping(source = "task.taskId.value", target = "taskId")
    @Mapping(source = "task.catalogId.value", target = "catalogId")
    @Mapping(source = "task.taskSource.value", target = "taskSource")
    TaskDTO fromTask(Task task, String catalogName);

    @Mapping(source = "taskId.value", target = "taskId")
    TaskSyntaxDTO toTaskSyntaxDTO(Task task);

    @Mapping(source = "catalogId.value", target = "catalogId")
    @Mapping(source = "pluginId.value", target = "pluginId")
    CatalogDTO fromCatalog(Catalog catalog);

    @Mapping(source = "functionId.value", target = "functionId")
    @Mapping(source = "catalogId.value", target = "catalogId")
    FunctionDTO fromFunction(Function function);

    @Mapping(source = "pluginId.value", target = "pluginId")
    PluginDTO fromPlugin(Plugin plugin);

    List<TaskDTO> fromTaskList(List<Task> taskList);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "sqlId.value", target = "sqlId")
    TaskSqlDTO fromTaskSql(TaskSql taskSql);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "sqlId.value", target = "sqlId")
    @Mapping(source = "functionId.value", target = "functionId")
    TaskFunctionDTO fromTaskFunction(TaskFunction taskFunction);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "sqlId.value", target = "sqlId")
    TaskLineageDTO fromTaskLineage(TaskLineage taskLineage);

    List<FunctionDTO> fromFunctionList(List<Function> functionList);

    @Mapping(source = "userId.value", target = "userId")
    UserDTO fromUser(User user);

    @Mapping(source = "user.userId.value", target = "userId")
    UserDTO fromUserPermissions(User user, List<Permission> permissionList);

    @Mapping(source = "user.userId.value", target = "userId")
    UserDTO fromUserRoles(User user, List<Role> roleList);


    @Mapping(source = "roleId.value", target = "roleId")
    RoleDTO fromRole(Role role);

    @Mapping(source = "permissionId.value", target = "permissionId")
    PermissionDTO fromPermission(Permission permission);

    @Mapping(source = "auditId.value", target = "auditId")
    AuditDTO fromAudit(Audit audit);

    @AfterMapping
    default void setTaskLineageGraph(@MappingTarget TaskDTO taskDTO, Task task, String catalogName) {
        LineageGraph lineageGraph = toLineageGraph(task.getTableGraph(),
                task.getColumnGraph(),
                catalogName,
                task.getDatabase()
        );
        taskDTO.setLineageGraph(lineageGraph);
    }

    default LineageGraph toLineageGraph(TableGraph tableGraph, ColumnGraph columnGraph, String catalogName, String database) {
        LineageGraph lineageGraph = new LineageGraph();
        if (tableGraph == null) {
            return lineageGraph;
        }
        List<Vertex> vertexList = tableGraph.queryNodeSet()
                .stream()
                .map(tableNode -> {
                    List<Column> columnList = tableNode.getColumnNodeList()
                            .stream()
                            .map(columnNode -> new Column(columnNode.getNodeId().toString(), columnNode.getNodeName(), columnNode.getChildrenCnt()))
                            .collect(Collectors.toList());

                    String optimizedName = optimizeTableName(catalogName, database, tableNode.getNodeName());
                    return new Vertex().setId(tableNode.getNodeId().toString())
                            .setName(optimizedName)
                            .setColumns(columnList)
                            .setHasUpstream(!tableNode.getParentIdSet().isEmpty())
                            .setHasDownstream(!tableNode.getChildIdSet().isEmpty())
                            .setChildrenCnt(tableNode.getChildrenCnt());
                })
                .collect(Collectors.toList());

        // add table edges
        List<Link> linkList = tableGraph.getEdgeSet()
                .stream()
                .map(tableEdge -> new TableLink(tableEdge.getEdgeId().toString()
                        , tableEdge.getSource().getNodeId().toString()
                        , tableEdge.getTarget().getNodeId().toString()
                        , tableEdge.getSqlSource()))
                .collect(Collectors.toList());

        // add column edges
        linkList.addAll(columnGraph.getEdgeSet()
                .stream()
                .map(columnEdge -> new ColumnLink(columnEdge.getEdgeId().toString()
                        , columnEdge.getSource().getTableNodeId().toString()
                        , columnEdge.getTarget().getTableNodeId().toString()
                        , columnEdge.getSource().getNodeId().toString()
                        , columnEdge.getTarget().getNodeId().toString()
                        , Strings.nullToEmpty(columnEdge.getTransform())
                ))
                .collect(Collectors.toList())
        );
        return lineageGraph.setNodes(vertexList).setLinks(linkList);
    }

    default String optimizeTableName(String catalogName, String database, String tableName) {
        if (tableName.startsWith(catalogName)) {
            tableName = tableName.replaceFirst(catalogName + DELIMITER, "");
        }
        if (tableName.startsWith(database)) {
            tableName = tableName.replaceFirst(database + DELIMITER, "");
        }
        return tableName;
    }
}
