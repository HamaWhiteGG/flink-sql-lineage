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

package com.hw.lineage.server.interfaces.controller;

import com.hw.lineage.common.enums.StorageType;
import com.hw.lineage.server.application.command.storage.DeleteStorageCmd;
import com.hw.lineage.server.application.service.StorageService;
import com.hw.lineage.server.interfaces.aspect.AuditLog;
import com.hw.lineage.server.interfaces.aspect.SkipLogAspect;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.MalformedURLException;

import static com.hw.lineage.common.enums.audit.ModuleCode.STORAGE;
import static com.hw.lineage.common.enums.audit.OperationType.*;
import static com.hw.lineage.common.util.Preconditions.checkArgument;

/**
 * @description: StorageController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Storages API")
@RequestMapping("/storages")
public class StorageController {

    @javax.annotation.Resource
    private StorageService storageService;

    @SkipLogAspect
    @PostMapping("/upload")
    @AuditLog(module = STORAGE, type = UPLOAD, descr = "'Upload File: ' + #file.originalFilename", params = false)
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file, @NotNull StorageType storageType)
            throws IOException {
        checkArgument(!file.isEmpty(), "failed to store empty file.");
        String filePath = storageService.uploadFile(file, storageType);
        return Result.success(ResultMessage.UPLOAD_SUCCESS, filePath);
    }

    @SkipLogAspect
    @GetMapping("/download")
    @AuditLog(module = STORAGE, type = DOWNLOAD, descr = "'Download file: ' + #filePath")
    public ResponseEntity<Resource> downloadFile(@NotBlank String filePath) throws MalformedURLException {
        Resource file = storageService.downloadFile(filePath);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename())
                .body(file);
    }

    @DeleteMapping("")
    @AuditLog(module = STORAGE, type = DELETE, descr = "'Delete File: ' + #command.filePath")
    public Result<Boolean> deleteFile(@Valid @RequestBody DeleteStorageCmd command) throws IOException {
        storageService.deleteFile(command.getFilePath());
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }
}
