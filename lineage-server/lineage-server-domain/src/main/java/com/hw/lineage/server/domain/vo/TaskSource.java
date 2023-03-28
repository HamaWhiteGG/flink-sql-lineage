package com.hw.lineage.server.domain.vo;

import com.hw.lineage.common.util.Base64Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TaskSource
 * @author: HamaWhite
 */
@Data
public class TaskSource {

    /**
     * ;(?=([^'"]*(['"])[^'"]*(['"]))*[^'"]*$)
     * <p>
     * Note that in order to avoid sonar S5998, + is added after the penultimate *
     */
    private static final String SPLIT_REGEX = ";(?=([^\'\"]*([\'\"])[^\'\"]*([\'\"]))*+[^\'\"]*$)";

    private static final String NEWLINE_REGEX = "\r?\n";


    private final String value;

    public TaskSource(String value) {
        this.value = value;
    }

    /**
     * Intercept according to the semicolon,
     * but ignore a semicolon surrounded by single quotes or double quotes inside SQL
     * <p>
     * Note that in order to avoid sonar S5998, + is added after the last *
     */
    public List<SplitSource> split() {
        List<SplitSource> splitList = new ArrayList<>();
        if (StringUtils.isNotEmpty(value)) {
            // base64 decode
            String source = Base64Utils.decode(value);
            // split the SQL code into separate statements
            String[] statements = source.split(SPLIT_REGEX);
            long startLineNumber = 1;
            // process comments and record the start line number of the statement
            for (String statement : statements) {
                if (statement.trim().isEmpty()) {
                    continue;
                }
                // source is preceded by comment lines or new line
                String[] lines = statement.split(NEWLINE_REGEX);
                for (String line : lines) {
                    line = line.trim();
                    if (line.startsWith("--") || line.isEmpty()) {
                        startLineNumber++;
                    }
                }
                statement = statement.replaceAll("--[^'\n]*('[^'\n]*')?[^'\n]*+", "").trim();
                splitList.add(new SplitSource(statement, startLineNumber));
                // the subtracted part supports the unwrapped
                startLineNumber += statement.split(NEWLINE_REGEX).length - (statement.endsWith(NEWLINE_REGEX) ? 0 : 1);
            }
        }
        return splitList;
    }

    @Data
    @AllArgsConstructor
    public static class SplitSource {

        private String sqlSource;

        private Long startLineNumber;
    }
}
