package com.hw.lineage.server.domain.query.user;

import com.hw.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;
import lombok.ToString;

/**
 * @description: UserQuery
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class UserQuery extends PageOrderCriteria {

    private String username;
}