package com.github.lucasdevrj.bibliotech.categoria;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

}
