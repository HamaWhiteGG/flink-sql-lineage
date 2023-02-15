package com.lineage.server.infrastructure.facede.impl;

import com.hw.lineage.common.exception.LineageException;
import com.lineage.server.domain.facade.StorageFacade;
import com.lineage.server.domain.vo.Storage;
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
    public String store(Storage storage, InputStream inputStream) throws IOException {
        Path destPath = buildPath(storage);
        if (Files.exists(destPath)) {
            LOG.warn("destPath {} already exists and will be replaced", destPath);
        }
        Files.copy(inputStream, destPath, StandardCopyOption.REPLACE_EXISTING);
        return destPath.toUri().toString();
    }

    @Override
    public void delete(Storage storage) throws IOException {
        Files.deleteIfExists(buildPath(storage));
    }

    @Override
    public Resource loadAsResource(Storage storage) throws MalformedURLException {
        Resource resource = new UrlResource(buildPath(storage).toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new LineageException("could not read file: " + storage.getFileName());
        }
    }

    private Path buildPath(Storage storage) {
        return rootLocation.resolve(storage.getFileName());
    }

}
