package com.github.lucasdevrj.bibliotech;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private int numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private CategoriaModel categoria;
    private AutorModel autor;
    private String idioma;

    public LivroModel() {
    }

    public LivroModel(String titulo, AutorModel autor, CategoriaModel categoria, LocalDate dataPublicacao, String isbn, int numeroPaginas, String idioma) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.idioma = idioma;
    }
}
