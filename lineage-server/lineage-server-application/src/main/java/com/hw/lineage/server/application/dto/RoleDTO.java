package com.hw.lineage.server.application.dto;

import com.hw.lineage.server.application.dto.basic.RootDTO;
import lombok.Data;

/**
 * @description: RoleDTO
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class RoleDTO extends RootDTO {
    private Long roleId;

    private String roleName;
}
