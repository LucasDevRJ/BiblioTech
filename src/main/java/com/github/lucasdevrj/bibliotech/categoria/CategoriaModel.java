package com.github.lucasdevrj.bibliotech.categoria;

import com.github.lucasdevrj.bibliotech.livro.LivroModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categorias")
@NoArgsConstructor
@Data
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<LivroModel> livros;

    public CategoriaModel(String nome) {
        this.nome = nome;
    }
}
