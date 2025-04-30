package com.github.lucasdevrj.bibliotech.autor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private AutorRepository autorRepository;
    private AutorMapper autorMapper;

    public AutorService(AutorRepository autorRepository, AutorMapper autorMapper) {
        this.autorRepository = autorRepository;
        this.autorMapper = autorMapper;
    }

    public List<AutorDTO> listarTodoOsAutores() {
        List<AutorModel> autores = autorRepository.findAll();
        return autores.stream().map(autorMapper::map).collect(Collectors.toList());
    }

    public AutorDTO exibirAutorPorId(Long id) {
        Optional<AutorModel> autorPorId = autorRepository.findById(id);
        return autorPorId.map(autorMapper::map).orElse(null);
    }

    public AutorDTO adicionarAutor(AutorDTO autorDTO) {
        AutorModel autor = autorMapper.map(autorDTO);
        autor = autorRepository.save(autor);
        return autorMapper.map(autor);
    }

    public void deletarAutorPorId(Long id) {
        autorRepository.deleteById(id);
    }

    public AutorDTO atualizarAutorPorId(Long id, AutorDTO autorDTO) {
        Optional<AutorModel> autorPorId = autorRepository.findById(id);
        if (autorPorId.isPresent()) {
            AutorModel autorAtualizado = autorMapper.map(autorDTO);
            autorAtualizado.setId(id);
            AutorModel autorSalvo = autorRepository.save(autorAtualizado);
            return autorMapper.map(autorSalvo);
        }
        return null;
    }
}
