package com.hw.lineage.server.domain.query.role;

import com.hw.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;
import lombok.ToString;

/**
 * @description: RoleQuery
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@ToString(callSuper = true)
public class RoleQuery extends PageOrderCriteria {

    private String roleName;
}