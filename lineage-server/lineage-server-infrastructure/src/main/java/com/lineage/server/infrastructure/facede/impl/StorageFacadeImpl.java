package com.lineage.server.infrastructure.facede.impl;

import com.hw.lineage.common.exception.LineageException;
import com.lineage.server.domain.facade.StorageFacade;
import com.lineage.server.infrastructure.config.LineageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @description: StorageFacadeImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/12 3:21 PM
 */
@Service
public class StorageFacadeImpl implements StorageFacade {

    private static final Logger LOG = LoggerFactory.getLogger(StorageFacadeImpl.class);

    private final Path rootLocation;

    public StorageFacadeImpl(LineageConfig config) {
        this.rootLocation = Paths.get(config.getStorageDir());
    }

    @Override
    public void init() throws IOException {
        if (Files.notExists(rootLocation)) {
            Files.createDirectory(rootLocation);
            LOG.info("created storageDir: {}", rootLocation.toAbsolutePath());
        }
    }

    @Override
    public String store(String fileName, InputStream inputStream) throws IOException {
        Path destPath = rootLocation.resolve(fileName);
        if (Files.exists(destPath)) {
            LOG.warn("destPath {} already exists and will be replaced", destPath);
        }
        Files.copy(inputStream, destPath, StandardCopyOption.REPLACE_EXISTING);
        return destPath.toUri().toString();
    }

    @Override
    public void delete(String fileName) throws IOException {
        Files.deleteIfExists(rootLocation.resolve(fileName));
    }

    @Override
    public Resource loadAsResource(String fileName) throws MalformedURLException {
        Resource resource = new UrlResource(rootLocation.resolve(fileName).toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new LineageException("could not read file: " + fileName);
        }
    }
}
