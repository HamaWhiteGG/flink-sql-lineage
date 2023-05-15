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

package com.hw.lineage.server.application.service.impl;

import com.hw.lineage.common.enums.StorageType;
import com.hw.lineage.server.application.service.StorageService;
import com.hw.lineage.server.domain.facade.StorageFacade;
import com.hw.lineage.server.domain.vo.Storage;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * @description: StorageServiceImpl
 * @author: HamaWhite
 */
@Service("storageService")
public class StorageServiceImpl implements StorageService {

    @javax.annotation.Resource
    private StorageFacade storageFacade;

    @Override
    public void init() throws IOException {
        storageFacade.init();
    }

    @Override
    public String uploadFile(MultipartFile file, StorageType storageType) throws IOException {
        Storage storage = new Storage(file.getOriginalFilename(),storageType);
        // store file
        try (InputStream inputStream = file.getInputStream()) {
            return storageFacade.store(storage, inputStream);
        }
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        storageFacade.delete(filePath);
    }

    @Override
    public Resource downloadFile(String filePath) throws MalformedURLException {
        return storageFacade.loadAsResource(filePath);
    }
}
