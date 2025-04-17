package com.github.lucasdevrj.bibliotech.livro;

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
    private String titulo;
    private String resumo;
    private int numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorModel autor;

    private String idioma;
}
