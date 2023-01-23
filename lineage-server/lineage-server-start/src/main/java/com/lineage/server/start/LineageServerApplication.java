package com.lineage.server.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: LineageServerApplication
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 8:35 PM
 */
@SpringBootApplication(scanBasePackages = {"com.lineage.server.*"})
public class LineageServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LineageServerApplication.class,args);
    }
}
