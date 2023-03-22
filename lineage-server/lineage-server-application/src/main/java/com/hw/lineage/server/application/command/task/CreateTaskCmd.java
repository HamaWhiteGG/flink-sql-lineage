package com.hw.lineage.server.application.command.task;

import com.hw.lineage.server.domain.query.BasicCriteria;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: CreateTaskCmd
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class CreateTaskCmd extends BasicCriteria {

    @NotBlank
    private String taskName;

    private String descr;

    @NotNull
    private Long catalogId;

    @NotBlank
    private String database;

}
