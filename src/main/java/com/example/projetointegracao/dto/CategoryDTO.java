package com.example.projetointegracao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@With
@Accessors(chain = true)
public class CategoryDTO {
    private Long id;
    private String name;
    private Long lineId;
    private List<ProductDTO> products;

    @Override
    public String toString() {
        return this.name;
    }
}
