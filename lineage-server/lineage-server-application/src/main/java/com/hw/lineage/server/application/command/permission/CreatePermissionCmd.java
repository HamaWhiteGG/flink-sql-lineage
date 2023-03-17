package com.hw.lineage.server.application.command.permission;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description: CreatePermissionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class CreatePermissionCmd implements Serializable {

    @NotBlank
    private String permissionGroup;

    @NotBlank
    private String permissionName;

    @NotBlank
    private String permissionCode;
}
