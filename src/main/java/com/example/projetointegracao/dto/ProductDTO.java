package com.example.projetointegracao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@With
@Accessors(chain = true)
public class ProductDTO {
    private Long id;
    private String name;
    private Long categoryId;
}
