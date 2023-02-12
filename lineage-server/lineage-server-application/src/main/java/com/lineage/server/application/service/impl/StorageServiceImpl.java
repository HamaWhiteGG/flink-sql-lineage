package com.lineage.server.application.service.impl;

import com.lineage.server.application.service.StorageService;
import com.lineage.server.domain.facade.StorageFacade;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import static com.hw.lineage.common.util.Constant.FILE_TYPE_JAR;
import static com.hw.lineage.common.util.Preconditions.checkArgument;
import static com.hw.lineage.common.util.Preconditions.checkNotNull;

/**
 * @description: StorageServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/12 3:24 PM
 */
@Service
public class StorageServiceImpl implements StorageService {

    @javax.annotation.Resource
    private StorageFacade storageFacade;

    @Override
    public void init() throws IOException {
        storageFacade.init();
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        checkArgument(!file.isEmpty(), "failed to store empty file.");

        String fileName = file.getOriginalFilename();
        // for sonar check
        if (fileName != null) {
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            checkArgument(suffix.equalsIgnoreCase(FILE_TYPE_JAR),
                    "file type is %s, only support %s", suffix, FILE_TYPE_JAR);
        }

        checkNotNull(fileName, "fileName cannot be null");
        // store file
        try (InputStream inputStream = file.getInputStream()) {
            return storageFacade.store(fileName, inputStream);
        }
    }

    @Override
    public void deleteFile(String fileName) throws IOException {
        storageFacade.delete(fileName);
    }

    @Override
    public Resource downloadFile(String fileName) throws MalformedURLException {
        return storageFacade.loadAsResource(fileName);
    }
}
