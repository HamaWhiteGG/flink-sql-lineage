package com.hw.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.audit.CreateAuditCmd;
import com.hw.lineage.server.application.dto.AuditDTO;
import com.hw.lineage.server.domain.query.audit.AuditQuery;

/**
 * @description: AuditService
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface AuditService {

    /**
     * Used internally by the system
     */
    Long createAudit(CreateAuditCmd command);

    AuditDTO queryAudit(Long auditId);

    PageInfo<AuditDTO> queryAudits(AuditQuery auditQuery);

    void deleteAudit(Long auditId);
}
