package com.lineage.server.domain.query.task;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: TaskCheck
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 7:33 PM
 */
@Data
public class TaskCheck {

    @NotNull
    private String taskName;
}
