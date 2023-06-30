package com.vs.clientserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {
    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/")
    public Mono<String> getResourceFormClient(){
        return this.webClient
                .get()
                .uri("http://localhost:9091/resource-server")
                .retrieve()
                .bodyToMono(String.class);
    }
}
