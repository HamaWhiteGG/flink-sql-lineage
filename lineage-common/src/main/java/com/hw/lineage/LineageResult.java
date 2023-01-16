package com.hw.lineage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static com.hw.lineage.Constant.DELIMITER;

/**
 * @description: Result
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2022/8/7 12:48 AM
 */
@Data
@Builder
@AllArgsConstructor
public class LineageResult {

    private String sourceCatalog;

    private String sourceDatabase;

    private String sourceTable;

    private String sourceColumn;

    private String targetCatalog;

    private String targetDatabase;

    private String targetTable;

    private String targetColumn;

    /**
     * Stores the expression for data conversion,
     * which source table fields are transformed by which expression the target field
     */
    private String transform;

    public LineageResult(String sourceTablePath, String sourceColumn
            , String targetTablePath, String targetColumn, String transform) {
        String[] sourceItems = sourceTablePath.split("\\" + DELIMITER);
        String[] targetItems = targetTablePath.split("\\" + DELIMITER);

        this.sourceCatalog = sourceItems[0];
        this.sourceDatabase = sourceItems[1];
        this.sourceTable = sourceItems[2];
        this.sourceColumn = sourceColumn;
        this.targetCatalog = targetItems[0];
        this.targetDatabase = targetItems[1];
        this.targetTable = targetItems[2];
        this.targetColumn = targetColumn;
        this.transform = transform;
    }
}
