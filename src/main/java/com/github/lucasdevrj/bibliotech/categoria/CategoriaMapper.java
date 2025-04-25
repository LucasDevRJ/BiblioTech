package com.github.lucasdevrj.bibliotech.categoria;

import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaModel map(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(categoriaDTO.getId());
        categoriaModel.setNome(categoriaDTO.getNome());
        categoriaModel.setDescricao(categoriaDTO.getDescricao());
        return categoriaModel;
    }

    public CategoriaDTO map(CategoriaModel categoriaModel) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoriaModel.getId());
        categoriaDTO.setNome(categoriaModel.getNome());
        categoriaDTO.setDescricao(categoriaModel.getDescricao());
        return categoriaDTO;
    }
}
