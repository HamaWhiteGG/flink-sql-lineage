package com.hw.lineage.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: FunctionInfo
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FunctionInfo {

    private String functionName;

    private String invocation;

    private String className;

    private String descr;

}
