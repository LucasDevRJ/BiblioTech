package com.github.lucasdevrj.bibliotech.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.lucasdevrj.bibliotech.autor.AutorModel;
import com.github.lucasdevrj.bibliotech.categoria.CategoriaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "livros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String resumo;
    private int numeroPaginas;

    @Column(nullable = false, unique = true, length = 13)
    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorModel autor;

    private String idioma;
}
