package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<LivroModel> listarTodosOsLivros() {
        return livroRepository.findAll();
    }

}
