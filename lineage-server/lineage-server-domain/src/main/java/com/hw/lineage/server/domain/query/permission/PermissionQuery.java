package com.hw.lineage.server.domain.query.permission;

import com.hw.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;
import lombok.ToString;

/**
 * @description: PermissionQuery
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@ToString(callSuper = true)
public class PermissionQuery extends PageOrderCriteria {

    private String permissionName;

    private String permissionCode;
}