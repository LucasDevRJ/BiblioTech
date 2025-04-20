package com.github.lucasdevrj.bibliotech.autor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorModel> listarTodoOsAutores() {
        return autorRepository.findAll();
    }

}
