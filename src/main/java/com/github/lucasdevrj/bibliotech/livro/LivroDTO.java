package com.github.lucasdevrj.bibliotech.livro;
import com.github.lucasdevrj.bibliotech.autor.AutorModel;
import com.github.lucasdevrj.bibliotech.categoria.CategoriaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivroDTO {

    private Long id;
    private String titulo;
    private String resumo;
    private int numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private CategoriaModel categoria;
    private AutorModel autor;
    private String idioma;
}
