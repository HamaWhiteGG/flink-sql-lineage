package com.lineage.server.application.cqe.command.task;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdateTaskCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 11:49 AM
 */
@Data
public class UpdateTaskCmd {

    @NotNull
    private Long taskId;

    private String taskName;

    private String descr;

    private Long pluginId;

    private Long catalogId;

    private String source;

}
