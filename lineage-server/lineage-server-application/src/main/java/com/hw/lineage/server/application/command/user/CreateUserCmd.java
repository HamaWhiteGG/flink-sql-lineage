package com.hw.lineage.server.application.command.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description: CreateUserCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class CreateUserCmd implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
