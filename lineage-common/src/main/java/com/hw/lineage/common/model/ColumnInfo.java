package com.hw.lineage.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: ColumnInfo
 * @author: HamaWhite
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ColumnInfo {

    private String columnName;

    private String columnType;

    private String comment;

    private Boolean primaryKey;

    private String watermark;
}
