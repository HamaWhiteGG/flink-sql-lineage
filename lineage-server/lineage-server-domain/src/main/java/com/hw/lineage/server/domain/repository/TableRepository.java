package com.hw.lineage.server.domain.repository;

import com.hw.lineage.server.domain.entity.Table;
import com.hw.lineage.server.domain.repository.basic.Repository;
import com.hw.lineage.server.domain.vo.TableId;

import java.util.List;

/**
 * @description: TableRepository
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface TableRepository extends Repository<Table, TableId> {

    List<Table> findMemory();
}
