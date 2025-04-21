package com.github.lucasdevrj.bibliotech.categoria;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaModel> listarTodasAsCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel exibirCategoriaPorId(Long id) {
        Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

}
