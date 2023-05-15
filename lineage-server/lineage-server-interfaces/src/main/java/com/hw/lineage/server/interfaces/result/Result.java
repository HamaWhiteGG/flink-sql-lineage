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

package com.hw.lineage.server.interfaces.result;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @description: ServerResult
 * @author: HamaWhite
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;
    private Integer code;

    private String message;

    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return success("");
    }

    public static <T> Result<T> success(final String msg) {
        return (Result<T>) success(msg, Boolean.TRUE);
    }

    public static <T> Result<T> success(final T data) {
        return success(null, data);
    }

    public static <T> Result<T> success(final String msg, final T data) {
        return get(ResultCode.SUCCESSFUL, msg, data);
    }

    public static <T> Result<T> error(final String msg) {
        return error(ResultCode.ERROR, msg);
    }

    public static <T> Result<T> error(final int code, final String msg) {
        return (Result<T>) get(code, msg, Boolean.FALSE);
    }

    public static <T> Result<T> timeout(final String msg) {
        return error(HttpStatus.REQUEST_TIMEOUT.value(), msg);
    }

    private static <T> Result<T> get(final int code, final String msg, final T data) {
        return new Result<>(code, msg, data);
    }
}
