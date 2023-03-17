package com.hw.lineage.server.application.command.role;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description: CreateRoleCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class CreateRoleCmd implements Serializable {

    @NotBlank
    private String roleName;
}
