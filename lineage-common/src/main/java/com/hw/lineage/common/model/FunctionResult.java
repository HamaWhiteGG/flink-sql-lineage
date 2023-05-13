package com.hw.lineage.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: FunctionResult
 * @author: HamaWhite
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FunctionResult {

    private String catalogName;

    private String database;

    private String functionName;

    public static Set<FunctionResult> buildResult(String catalog, String database, String[] expectedArray) {
        return Stream.of(expectedArray)
                .map(e -> new FunctionResult(catalog, database, e))
                .collect(Collectors.toSet());
    }
}
