package com.lineage.server.start;

import com.lineage.server.application.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @description: LineageServerApplication
 * @author: HamaWhite
 * @version: 1.0.0
 */
@SpringBootApplication(scanBasePackages = {"com.lineage.server.*"})
public class LineageServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LineageServerApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return args -> storageService.init();
    }
}
