package com.lineage.server.domain.vo;

import lombok.Data;

import static com.hw.lineage.common.util.Preconditions.checkArgument;
import static com.hw.lineage.common.util.Preconditions.checkNotNull;

/**
 * @description: Storage
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/13 7:14 PM
 */
@Data
public class Storage {

    public static final String FILE_TYPE_JAR = "jar";

    private String fileName;

    public Storage(String fileName) {
        checkNotNull(fileName, "fileName cannot be null");
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        checkArgument(suffix.equalsIgnoreCase(FILE_TYPE_JAR),
                "file type is %s, only support %s", suffix, FILE_TYPE_JAR);

        this.fileName = fileName;
    }
}
