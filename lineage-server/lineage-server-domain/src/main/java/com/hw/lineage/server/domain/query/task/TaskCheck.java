package com.hw.lineage.server.domain.query.task;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: TaskCheck
 * @author: HamaWhite
 */
@Data
public class TaskCheck implements Serializable {

    @NotNull
    private String taskName;
}
