package com.hw.lineage.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: FunctionResult
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/14 8:34 PM
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FunctionResult {

    private String functionName;

    private String functionFormat;

    private String functionClass;

    private String descr;

}
