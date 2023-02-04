package com.lineage.server.domain.vo;

import com.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: TaskId
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 10:21 PM
 */
@Data
public class TaskId implements Identifier {

    private final Long value;

    public TaskId(Long value) {
        this.value = value;
    }
}
