package com.hw.lineage.common.util;

import java.util.Base64;

/**
 * @description: Base64Utils
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/6 9:10 PM
 */
public class Base64Utils {
    private static final Base64.Decoder decoder = Base64.getDecoder();
    private static final Base64.Encoder encoder = Base64.getEncoder();

    private Base64Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static String encode(byte[] bytes) {
        return encoder.encodeToString(bytes);
    }

    public static String decode(String text) {
        return new String(decoder.decode(text));
    }
}
