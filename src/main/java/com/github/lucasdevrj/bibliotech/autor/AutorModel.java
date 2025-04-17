package com.github.lucasdevrj.bibliotech.autor;

import com.github.lucasdevrj.bibliotech.livro.LivroModel;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;
    private String biografia;

    @OneToMany(mappedBy = "autor")
    private List<LivroModel> livros;
}
