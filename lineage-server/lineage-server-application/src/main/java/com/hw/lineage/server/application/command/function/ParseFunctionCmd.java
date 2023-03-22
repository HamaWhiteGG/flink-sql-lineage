package com.hw.lineage.server.application.command.function;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: ParseFunctionCmd
 * @author: HamaWhite
 */
@Data
public class ParseFunctionCmd implements Serializable {

    @NotNull
    private Long pluginId;
    @NotBlank
    private String functionPath;

}
