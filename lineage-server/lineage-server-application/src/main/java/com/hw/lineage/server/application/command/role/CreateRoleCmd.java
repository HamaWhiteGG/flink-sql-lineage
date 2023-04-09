package com.hw.lineage.server.application.command.role;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description: CreateRoleCmd
 * @author: HamaWhite
 */
@Data
public class CreateRoleCmd implements Serializable {

    @NotBlank
    private String roleName;
}
