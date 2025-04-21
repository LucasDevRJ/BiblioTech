package com.github.lucasdevrj.bibliotech.autor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorModel> listarTodoOsAutores() {
        return autorRepository.findAll();
    }

    public AutorModel exibirAutorPorId(Long id) {
        Optional<AutorModel> autor = autorRepository.findById(id);
        return autor.orElse(null);
    }

}
