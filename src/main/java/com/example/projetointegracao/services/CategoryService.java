package com.example.projetointegracao.services;

import com.example.projetointegracao.dto.CategoryDTO;
import com.example.projetointegracao.dto.LineDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class CategoryService {
    private final WebClient webClient;

    public CategoryService() {
        webClient = new MainService().getWebClient();
    }

    public List<CategoryDTO> getCategoriesByLine(Long lineId) {
        return webClient.get()
                .uri("/categories/{lineId}", lineId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CategoryDTO>>() {})
                .block();
    }
}

