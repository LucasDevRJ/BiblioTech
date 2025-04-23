package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;
    private LivroMapper livroMapper;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
    }

    public List<LivroModel> listarTodosOsLivros() {
        return livroRepository.findAll();
    }

    public LivroModel exibirLivroPorId(Long id) {
        Optional<LivroModel> livroModel = livroRepository.findById(id);
        return livroModel.orElse(null);
    }

    public LivroDTO adicionarLivro(LivroDTO livroDTO) {
        LivroModel livro = livroMapper.map(livroDTO);
        livro = livroRepository.save(livro);
        return livroMapper.map(livro);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public LivroModel atualizarLivroPorId(Long id, LivroModel livroAtualizado) {
        if (livroRepository.existsById(id)) {
            livroAtualizado.setId(id);
            return livroRepository.save(livroAtualizado);
        }
        return null;
    }
}
