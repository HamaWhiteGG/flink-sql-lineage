package com.hw.lineage.common.util;

/**
 * @description: Utility class for Java arrays.
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/16 9:45 PM
 */
public class ArrayUtils {
    private ArrayUtils() {
    }

    public static String[] concat(String[] array1, String[] array2) {
        if (array1.length == 0) {
            return array2;
        }
        if (array2.length == 0) {
            return array1;
        }
        String[] resultArray = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, resultArray, 0, array1.length);
        System.arraycopy(array2, 0, resultArray, array1.length, array2.length);
        return resultArray;
    }
}
