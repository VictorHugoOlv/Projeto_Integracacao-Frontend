package com.example.projetointegracao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LineDTO {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
