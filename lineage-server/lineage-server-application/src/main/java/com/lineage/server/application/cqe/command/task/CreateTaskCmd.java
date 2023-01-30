package com.lineage.server.application.cqe.command.task;

import lombok.Data;

/**
 * @description: CreateTaskCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 11:40 AM
 */
@Data
public class CreateTaskCmd {

    private String taskName;

    private String descr;

    private Long pluginId;

    private Long catalogId;

}
