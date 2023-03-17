package com.hw.lineage.server.domain.query.permission;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: PermissionCheck
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class PermissionCheck implements Serializable {

    private String permissionName;

    private String permissionCode;
}

