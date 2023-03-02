package com.hw.lineage.server.application.command.role;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdateRoleCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UpdateRoleCmd {

    private Long roleId;

    private String roleName;
}
