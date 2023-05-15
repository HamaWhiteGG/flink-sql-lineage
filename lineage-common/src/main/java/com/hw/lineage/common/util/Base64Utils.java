/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.common.util;

import java.util.Base64;

/**
 * @description: Base64Utils
 * @author: HamaWhite
 */
public class Base64Utils {
    private static final Base64.Decoder decoder = Base64.getDecoder();
    private static final Base64.Encoder encoder = Base64.getEncoder();

    private Base64Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static String encode(String text) {
        return encoder.encodeToString(text.getBytes());
    }

    public static String encodeBytes(byte[] bytes) {
        return encoder.encodeToString(bytes);
    }

    public static String decode(String text) {
        return new String(decoder.decode(text));
    }

    public static byte[] decodeBytes(String text) {
        return decoder.decode(text);
    }
}
