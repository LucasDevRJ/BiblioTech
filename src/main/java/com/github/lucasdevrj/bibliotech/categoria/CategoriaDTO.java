package com.github.lucasdevrj.bibliotech.categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriaDTO {

    private Long id;
    private String nome;
    private String descricao;
}
