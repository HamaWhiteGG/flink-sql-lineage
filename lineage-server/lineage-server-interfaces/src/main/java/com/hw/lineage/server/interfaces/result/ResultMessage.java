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

/**
 * @description: ResultMessage
 * @author: HamaWhite
 */
public class ResultMessage {

    private ResultMessage() {
        throw new IllegalStateException("Utility class");
    }

    public static final String SUCCESS = "success";

    public static final String CREATE_SUCCESS = "create success";

    public static final String DELETE_SUCCESS = "delete success";

    public static final String UPDATE_SUCCESS = "update success";

    public static final String QUERY_SUCCESS = "query success";

    public static final String CHECK_SUCCESS = "check success";

    public static final String UPLOAD_SUCCESS = "upload success";

    public static final String QUERY_FAILED = "query failed";

    public static final String DELETE_FAILED = "delete failed";

    public static final String UPDATE_FAILED = "update failed";

    public static final String DETAIL_SUCCESS = "detail success";

    public static final String ANALYZE_LINEAGE_SUCCESS = "analyze lineage success";

    public static final String CHECK_SYNTAX_SUCCESS = "check syntax success";

    public static final String PARSE_FUNCTION_SUCCESS = "parse function success";

    public static final String LOGIN_SUCCESS = "login success";

    public static final String LOGOUT_SUCCESS = "logout success";

    public static final String NOT_LOGGED_IN = "please log in first";

    public static final String USER_ACCOUNT_EXPIRED = "user account expired";

    public static final String USER_ACCOUNT_OR_PASSWORD_ERROR = "user account or password error";

    public static final String USER_PASSWORD_EXPIRED = "user password expired";

    public static final String USER_ACCOUNT_DISABLE = "user account disable";

    public static final String USER_ACCOUNT_LOCKED = "user account locked";

    public static final String DETAIL_FAILED = "detail failed";

    public static final String NULL_POINTER_EXCEPTION = "null pointer exception";

    public static final String UNIQUE_INDEX_CONFLICT_ERROR = "unique index conflict, please enter again";

    public static final String TOKEN_HAS_NO_PERMISSION = "token has no permission";

}
