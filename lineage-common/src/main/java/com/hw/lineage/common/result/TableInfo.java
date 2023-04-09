package com.hw.lineage.common.result;

import com.hw.lineage.common.enums.TableKind;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @description: TableInfo
 * @author: HamaWhite
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TableInfo {

    private String tableName;

    private TableKind tableKind;

    private String comment;

    private List<ColumnInfo> columnList;

    /**
     * Properties of the table
     */
    private Map<String, String> propertiesMap;


}
