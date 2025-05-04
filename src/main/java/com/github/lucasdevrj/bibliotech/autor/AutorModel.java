package com.github.lucasdevrj.bibliotech.autor;

import com.github.lucasdevrj.bibliotech.livro.LivroModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
@NoArgsConstructor
@Data
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String nacionalidade;
    private LocalDate dataNascimento;
    private String biografia;
}
