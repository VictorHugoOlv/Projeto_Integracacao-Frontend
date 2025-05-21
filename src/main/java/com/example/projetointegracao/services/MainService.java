package com.example.projetointegracao.services;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Getter
public class MainService {
    private WebClient webClient;

    public MainService() {
        this.webClient = WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();
    }
}
