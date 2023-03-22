package com.hw.lineage.server.domain.query.permission;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: PermissionCheck
 * @author: HamaWhite
 */
@Data
public class PermissionCheck implements Serializable {

    private String permissionName;

    private String permissionCode;
}

