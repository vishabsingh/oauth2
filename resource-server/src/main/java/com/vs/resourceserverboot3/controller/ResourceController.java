package com.vs.resourceserverboot3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ResourceController {

    @GetMapping("/resource-server")
    public String getName() {
        return "ResourceController - " +LocalDateTime.now();
    }
}
