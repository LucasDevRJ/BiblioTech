package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private LivroRepository livroRepository;
    private LivroMapper livroMapper;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
    }

    public List<LivroDTO> listarTodosOsLivros() {
        List<LivroModel> livros = livroRepository.findAll();
        return livros.stream().map(livroMapper::transfereDeDTOParaModel).collect(Collectors.toList());
    }

    public LivroDTO exibirLivroPorId(Long id) {
        Optional<LivroModel> livroPorId = livroRepository.findById(id);
        return livroPorId.map(livroMapper::transfereDeDTOParaModel).orElse(null);
    }

    public List<LivroDTO> listarLivrosPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo).stream()
                .map(livroMapper::transfereDeDTOParaModel)
                .collect(Collectors.toList());
    }

    public List<LivroDTO> listarLivrosPorAutor(String nomeDoAutor) {
        return livroRepository.findByAutorNomeContainingIgnoreCase(nomeDoAutor).stream()
                .map(livroMapper::transfereDeDTOParaModel)
                .collect(Collectors.toList());
    }

    public List<LivroDTO> listarLivrosPorCategoria(String categoria) {
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(categoria).stream()
                .map(livroMapper::transfereDeDTOParaModel)
                .collect(Collectors.toList());
    }

    public List<LivroDTO> listarLivrosPorDatas(LocalDate dataInicio, LocalDate dataFim) {
        return livroRepository.findByDataPublicacaoBetween(dataInicio, dataFim).stream()
                .map(livroMapper::transfereDeDTOParaModel)
                .collect(Collectors.toList());
    }

    public Page<LivroDTO> listarLivrosComOrdenacao(Pageable pageable) {
        return livroRepository.findAll(pageable).map(livroMapper::transfereDeDTOParaModel);
    }

    public LivroDTO adicionarLivro(LivroDTO livroDTO) {
        LivroModel livro = livroMapper.transfereDeModelParaDTO(livroDTO);
        livro = livroRepository.save(livro);
        return livroMapper.transfereDeDTOParaModel(livro);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public LivroDTO atualizarLivroPorId(Long id, LivroDTO livroDTO) {
        Optional<LivroModel> livroExistente = livroRepository.findById(id);
        if (livroExistente.isPresent()) {
            LivroModel livroAtualizado = livroMapper.transfereDeModelParaDTO(livroDTO);
            livroAtualizado.setId(id);
            LivroModel livroSalvo = livroRepository.save(livroAtualizado);
            return livroMapper.transfereDeDTOParaModel(livroSalvo);
        }
        return null;
    }
}
