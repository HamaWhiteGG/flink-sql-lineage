package com.lineage.server.domain.facade;

import com.lineage.server.domain.vo.Storage;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * @description: StorageFacade
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/12 3:20 PM
 */
public interface StorageFacade {
    void init() throws IOException;

    String store(Storage storage, InputStream inputStream) throws IOException ;

    void delete(Storage storage) throws IOException;

     Resource loadAsResource(Storage storage) throws MalformedURLException;
}
