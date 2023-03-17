package com.hw.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.application.assembler.DtoAssembler;
import com.hw.lineage.server.application.command.audit.CreateAuditCmd;
import com.hw.lineage.server.application.dto.AuditDTO;
import com.hw.lineage.server.application.service.AuditService;
import com.hw.lineage.server.domain.entity.Audit;
import com.hw.lineage.server.domain.query.audit.AuditQuery;
import com.hw.lineage.server.domain.repository.AuditRepository;
import com.hw.lineage.server.domain.vo.AuditId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: AuditServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Service("auditService")
public class AuditServiceImpl implements AuditService {

    @Resource
    private AuditRepository repository;

    @Resource
    private DtoAssembler assembler;


    @Override
    public Long createAudit(CreateAuditCmd command) {
        Audit audit = new Audit()
                .setUserId(command.getUserId())
                .setUsername(command.getUsername())
                .setModuleCode(command.getModuleCode())
                .setOperationType(command.getOperationType())
                .setDescr(command.getDescr())
                .setDuration(command.getDuration())
                .setOperationStatus(command.getOperationStatus())
                .setIp(command.getIp())
                .setMethod(command.getMethod())
                .setParameters(command.getParameters())
                .setException(command.getException())
                .setCreateTime(System.currentTimeMillis())
                .setInvalid(false);

        audit = repository.save(audit);
        return audit.getAuditId().getValue();
    }

    @Override
    public AuditDTO queryAudit(Long auditId) {
        Audit audit = repository.find(new AuditId(auditId));
        return assembler.fromAudit(audit);
    }

    @Override
    public PageInfo<AuditDTO> queryAudits(AuditQuery auditQuery) {
        PageInfo<Audit> pageInfo = repository.findAll(auditQuery);
        return PageUtils.convertPage(pageInfo, assembler::fromAudit);
    }

    @Override
    public void deleteAudit(Long auditId) {
        repository.remove(new AuditId(auditId));
    }
}
