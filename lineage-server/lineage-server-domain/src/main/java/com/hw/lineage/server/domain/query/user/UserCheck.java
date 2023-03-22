package com.hw.lineage.server.domain.query.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: UserCheck
 * @author: HamaWhite
 */
@Data
public class UserCheck implements Serializable {

    @NotNull
    private String username;
}

