package com.lineage.server.interfaces.controller;

import com.lineage.server.application.service.StorageService;
import com.lineage.server.interfaces.aspect.SkipAspect;
import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @description: StorageController
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/12 2:49 PM
 */
@RestController
@Api(tags = "Storages API")
@RequestMapping("/storages")
public class StorageController {

    @javax.annotation.Resource
    private StorageService storageService;

    @SkipAspect
    @PostMapping("")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String filePath = storageService.uploadFile(file);
        return Result.success(ResultMessage.UPLOAD_SUCCESS, filePath);
    }

    @SkipAspect
    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileName") String fileName) throws MalformedURLException {
        Resource file = storageService.downloadFile(fileName);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename())
                .body(file);
    }

    @DeleteMapping("/{fileName}")
    public Result<Boolean> deleteFile(@PathVariable("fileName") String fileName) throws IOException {
        storageService.deleteFile(fileName);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }
}
