package com.hw.lineage.server.domain.query.function.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: FunctionTaskDTO
 * @author: HamaWhite
 */
@Data
public class FunctionTaskDTO implements Serializable {

    private Long taskId;

    private List<Long> sqlIdList;

    private Long createTime;
}
