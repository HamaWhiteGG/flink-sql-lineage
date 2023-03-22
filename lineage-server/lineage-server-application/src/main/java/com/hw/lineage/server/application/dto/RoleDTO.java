package com.hw.lineage.server.application.dto;

import com.hw.lineage.server.application.dto.basic.RootDTO;
import lombok.Data;

import java.util.List;

/**
 * @description: RoleDTO
 * @author: HamaWhite
 */
@Data
public class RoleDTO extends RootDTO {
    private Long roleId;

    private String roleName;

    private List<PermissionDTO> permissionList;

}
