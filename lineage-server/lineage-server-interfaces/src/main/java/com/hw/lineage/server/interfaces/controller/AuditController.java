package com.hw.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.dto.AuditDTO;
import com.hw.lineage.server.application.service.AuditService;
import com.hw.lineage.server.domain.query.audit.AuditQuery;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: AuditController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Audits API")
@RequestMapping("/audits")
public class AuditController {

    @Resource
    private AuditService auditService;

    @GetMapping("/{auditId}")
    public Result<AuditDTO> queryAudit(@PathVariable("auditId") Long auditId) {
        AuditDTO auditDTO = auditService.queryAudit(auditId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, auditDTO);
    }

    @GetMapping("")
    public Result<PageInfo<AuditDTO>> queryAudits(AuditQuery auditQuery) {
        PageInfo<AuditDTO> pageInfo = auditService.queryAudits(auditQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @DeleteMapping("/{auditId}")
    public Result<Boolean> deleteAudit(@PathVariable("auditId") Long auditId) {
        auditService.deleteAudit(auditId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }
}
