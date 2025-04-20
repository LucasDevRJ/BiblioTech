package com.github.lucasdevrj.bibliotech.categoria;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaModel> listarTodasAsCategorias() {
        return categoriaRepository.findAll();
    }

}
