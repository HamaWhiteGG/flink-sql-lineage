package com.hw.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.domain.entity.Audit;
import com.hw.lineage.server.domain.query.audit.AuditQuery;
import com.hw.lineage.server.domain.repository.basic.Repository;
import com.hw.lineage.server.domain.vo.AuditId;

/**
 * @description: AuditRepository
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface AuditRepository extends Repository<Audit, AuditId> {

    PageInfo<Audit> findAll(AuditQuery auditQuery);

}
