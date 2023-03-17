package com.hw.lineage.server.domain.query.role;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: RoleCheck
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class RoleCheck implements Serializable {

    @NotNull
    private String roleName;
}

