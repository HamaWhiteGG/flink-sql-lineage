package com.hw.lineage.server.application.service.impl;

import com.hw.lineage.server.application.service.TableService;
import com.hw.lineage.server.domain.entity.Table;
import com.hw.lineage.server.domain.facade.LineageFacade;
import com.hw.lineage.server.domain.query.catalog.CatalogEntry;
import com.hw.lineage.server.domain.repository.CatalogRepository;
import com.hw.lineage.server.domain.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: TableServiceImpl
 * @author: HamaWhite
 */
@Service("tableService")
public class TableServiceImpl implements TableService {

    private static final Logger LOG = LoggerFactory.getLogger(TableServiceImpl.class);

    @Resource
    private TableRepository tableRepository;

    @Resource
    private CatalogRepository catalogRepository;

    @Resource
    private LineageFacade lineageFacade;


    @Override
    public void createMemoryTables() {
        List<Table> tableList = tableRepository.findMemory();
        // create tables of memory catalog in flink
        tableList.forEach(this::createTableInEngine);
    }


    private void createTableInEngine(Table table) {
        CatalogEntry entry = catalogRepository.findEntry(table.getCatalogId());
        lineageFacade.createTable(entry.getPluginCode(), entry.getCatalogName(), table.getDatabase(), table.getDdl());
        LOG.info("created table: [{}] in catalog: [{}]", table.getTableName(), entry.getCatalogName());
    }
}