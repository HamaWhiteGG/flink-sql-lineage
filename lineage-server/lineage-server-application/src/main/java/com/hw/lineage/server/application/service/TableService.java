package com.hw.lineage.server.application.service;

/**
 * @description: TableService
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface TableService {

    /**
     * Create the tables of memory type catalog to flink when the application start
     */
    void createMemoryTables();
}
