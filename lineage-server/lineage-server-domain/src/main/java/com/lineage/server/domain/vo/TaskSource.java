package com.lineage.server.domain.vo;

import com.hw.lineage.common.util.Base64Utils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * @description: TaskSource
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/1 10:01 PM
 */
@Data
public class TaskSource {

    /**
     * ;(?=([^'"]*(['"])[^'"]*(['"]))*[^'"]*$)
     * <p>
     * Note that in order to avoid sonar S5998, + is added after the penultimate *
     */
    private static final String REGEX = ";(?=([^\\'\\\"]*([\\'\\\"])[^\\'\\\"]*([\\'\\\"]))*+[^\\'\\\"]*$)";

    private final String value;

    public TaskSource(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("source cannot be empty");
        }
        this.value = value;
    }

    /**
     * Intercept according to the semicolon,
     * but ignore a semicolon surrounded by single quotes or double quotes inside SQL
     * <p>
     * Note that in order to avoid sonar S5998, + is added after the last *
     */
    public String[] splitSource() {
        // base64 decode
        String source = Base64Utils.decode(value);
        // remove comments and line break
        source = source.replace("\u00A0", " ")
                .replaceAll("--[^'\n]*('[^'\n]*')?[^'\n]*+", "")
                .replaceAll("[\r\n]+", " ")
                .replaceAll("\n+", " ")
                .trim();

        // split
        return Stream.of(source.split(REGEX))
                .filter(e -> !e.isEmpty())
                .map(String::trim)
                .toArray(String[]::new);
    }
}