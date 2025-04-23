package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public LivroModel map(LivroDTO livroDTO) {
        LivroModel livroModel = new LivroModel();
        livroModel.setId(livroDTO.getId());
        livroModel.setTitulo(livroDTO.getTitulo());
        livroModel.setResumo(livroDTO.getResumo());
        livroModel.setNumeroPaginas(livroDTO.getNumeroPaginas());
        livroModel.setIsbn(livroDTO.getIsbn());
        livroModel.setDataPublicacao(livroDTO.getDataPublicacao());
        livroModel.setCategoria(livroDTO.getCategoria());
        livroModel.setAutor(livroDTO.getAutor());
        livroModel.setIdioma(livroDTO.getIdioma());
        return livroModel;
    }

    public LivroDTO map(LivroModel livroModel) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livroModel.getId());
        livroDTO.setTitulo(livroModel.getTitulo());
        livroDTO.setResumo(livroModel.getResumo());
        livroDTO.setNumeroPaginas(livroModel.getNumeroPaginas());
        livroDTO.setIsbn(livroModel.getIsbn());
        livroDTO.setDataPublicacao(livroModel.getDataPublicacao());
        livroDTO.setCategoria(livroModel.getCategoria());
        livroDTO.setAutor(livroModel.getAutor());
        livroDTO.setIdioma(livroModel.getIdioma());
        return livroDTO;
    }

}
