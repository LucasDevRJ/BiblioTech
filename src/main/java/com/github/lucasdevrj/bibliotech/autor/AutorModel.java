package com.github.lucasdevrj.bibliotech.autor;

import jakarta.persistence.*;

import java.time.LocalDate;

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
}
