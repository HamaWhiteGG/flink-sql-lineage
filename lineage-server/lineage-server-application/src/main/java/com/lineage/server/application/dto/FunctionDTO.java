package com.lineage.server.application.dto;

import lombok.Data;

/**
 * @description: FunctionDTO
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:31 PM
 */
@Data
public class FunctionDTO extends BasicDTO {

    private Long functionId;

    private String functionName;

    private String functionFormat;

    private String functionPath;

    private String functionClass;

    private String descr;
}
