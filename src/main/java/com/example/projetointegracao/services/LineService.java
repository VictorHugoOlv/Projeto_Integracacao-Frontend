package com.example.projetointegracao.services;

import com.example.projetointegracao.dto.LineDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class LineService {

    private final WebClient webClient;

    public LineService() {
        webClient = new MainService().getWebClient();
    }

    public List<LineDTO> getAllLines() {

        return webClient.get()
                .uri("/lines")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<LineDTO>>() {})
                .block();
    }
}
