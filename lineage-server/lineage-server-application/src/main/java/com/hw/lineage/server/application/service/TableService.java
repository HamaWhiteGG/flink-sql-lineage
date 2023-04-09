package com.hw.lineage.server.application.service;

/**
 * @description: TableService
 * @author: HamaWhite
 */
public interface TableService {

    /**
     * Create the tables of memory type catalog to flink when the application start
     */
    void createMemoryTables();
}
