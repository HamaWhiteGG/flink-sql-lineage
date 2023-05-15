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

package com.hw.lineage.server.interfaces.enhanced;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.exception.LineageException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: Customize an HttpRequest that supports additional parameters
 * @author: HamaWhite
 */
public class EnhancedHttpRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    private Map<String, String[]> parameters;

    /**
     * Create a new request wrapper that will merge additional parameters into the request object
     * without prematurely reading parameters from the original request.
     */
    public EnhancedHttpRequestWrapper(HttpServletRequest request, Map<String, String> additionalMap) {
        super(request);
        enhancedParameters(additionalMap);
        enhancedBody(request, additionalMap);
    }

    private void enhancedParameters(Map<String, String> additionalMap) {
        parameters = new TreeMap<>();
        parameters.putAll(super.getParameterMap());
        // add additional parameters
        additionalMap.forEach((key, value) -> parameters.put(key, new String[]{value}));
    }

    @Override
    public String getParameter(String name) {
        String[] value = getParameterMap().get(name);
        if (value != null) {
            return value[0];
        }
        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        // return an unmodifiable collection because we need to uphold the interface contract.
        return Collections.unmodifiableMap(parameters);
    }


    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return getParameterMap().get(name);
    }


    /**
     * Get the stream in the request, adding additional parameters
     */
    public void enhancedBody(HttpServletRequest request, Map<String, String> additionalMap) {
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader streamReader = new InputStreamReader(request.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(streamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            throw new LineageException("Exception when trying to enhanced request body.", e);
        }
        if (builder.length() != 0) {
            JSONObject jsonObject = JSON.parseObject(builder.toString());
            // add additional parameters
            jsonObject.putAll(additionalMap);
            body = jsonObject.toJSONString().getBytes();
        } else {
            body = new byte[]{};
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(body);

        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return inputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                throw new UnsupportedOperationException();
            }
        };
    }
}
