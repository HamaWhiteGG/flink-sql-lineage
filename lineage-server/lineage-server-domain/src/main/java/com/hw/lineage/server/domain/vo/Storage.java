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

package com.hw.lineage.server.domain.vo;

import com.google.common.io.Files;
import com.hw.lineage.common.enums.StorageType;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

import static com.hw.lineage.common.util.Preconditions.checkArgument;
import static com.hw.lineage.common.util.Preconditions.checkNotNull;

/**
 * @description: Storage
 * @author: HamaWhite
 */
@Data
public class Storage {

    protected static final List<String> SUPPORT_FILE_TYPE = Arrays.asList("jar", "xml");

    private String fileName;

    private StorageType storageType;

    public Storage(String fileName, StorageType storageType) {
        checkNotNull(fileName, "fileName cannot be null");
        String extension = Files.getFileExtension(fileName);
        checkArgument(SUPPORT_FILE_TYPE.contains(extension),
                "file type is %s, only support %s", extension, SUPPORT_FILE_TYPE);

        this.fileName = fileName;
        this.storageType = storageType;
    }
}
