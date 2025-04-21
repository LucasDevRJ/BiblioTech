package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<LivroModel> listarTodosOsLivros() {
        return livroRepository.findAll();
    }

    public LivroModel exibirLivroPorId(Long id) {
        Optional<LivroModel> livroModel = livroRepository.findById(id);
        return livroModel.orElse(null);
    }

}
