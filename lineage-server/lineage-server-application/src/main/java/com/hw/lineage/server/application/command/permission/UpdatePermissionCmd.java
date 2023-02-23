package com.hw.lineage.server.application.command.permission;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdatePermissionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UpdatePermissionCmd {

    @NotNull
    private Long permissionId;

    private String permissionGroup;

    private String permissionName;

    private String permissionCode;
}
