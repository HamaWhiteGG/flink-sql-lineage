package com.lineage.server.application.command.task;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: CreateTaskCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 11:40 AM
 */
@Data
public class CreateTaskCmd {

    @NotBlank
    private String taskName;

    private String descr;

    @NotNull
    private Long pluginId;

    @NotNull
    private Long catalogId;

}
