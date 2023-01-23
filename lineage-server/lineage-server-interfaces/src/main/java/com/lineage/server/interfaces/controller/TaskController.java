package com.lineage.server.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TaskController
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 8:06 PM
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/hello")
    public String hello(){
        return "hello, spring boot!";
    }
}
