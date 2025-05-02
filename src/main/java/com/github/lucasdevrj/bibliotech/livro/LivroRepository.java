package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {

    List<LivroModel> findByTituloContainingIgnoreCase(String titulo);

    List<LivroModel> findByAutorNomeContainingIgnoreCase(String nome);

    List<LivroModel> findByCategoriaNomeContainingIgnoreCase(String categoria);

    List<LivroModel> findByDataPublicacaoBetween(LocalDate dataInicio, LocalDate dataFim);

}
