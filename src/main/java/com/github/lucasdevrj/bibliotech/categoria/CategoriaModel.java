package com.github.lucasdevrj.bibliotech.categoria;

import com.github.lucasdevrj.bibliotech.livro.LivroModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<LivroModel> livros;
}
