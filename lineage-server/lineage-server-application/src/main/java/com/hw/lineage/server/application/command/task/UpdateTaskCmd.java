package com.hw.lineage.server.application.command.task;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdateTaskCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UpdateTaskCmd {

    private Long taskId;

    private String taskName;

    private String descr;

    private Long pluginId;

    private Long catalogId;

    private String source;

}
