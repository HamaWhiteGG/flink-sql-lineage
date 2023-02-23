package com.hw.lineage.server.application.dto;

import com.hw.lineage.server.application.dto.basic.BasicDTO;
import lombok.Data;

/**
 * @description: FunctionDTO
 * @author: HamaWhite
 * @version: 1.0.0
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
