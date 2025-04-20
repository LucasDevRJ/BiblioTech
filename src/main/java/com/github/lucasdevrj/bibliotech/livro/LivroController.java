package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class LivroController {

    @GetMapping("/welcome")
    public String displaysWelcomeMessage() {
        return "Seja bem-vindo a BiblioTech!";
    }

    //Adicionar Livro (CREATE)
    @PostMapping("/adicionar")
    public String adicionarLivro() {
        return "Livro adicionado com sucesso!";
    }

    //Exibir todos os Livros (READ)
    @GetMapping("/listar")
    public String listarLivros() {
        return "Livros listados com sucesso!";
    }

    //Exibir Livro por ID (READ)
    @GetMapping("/exibirPorId")
    public String exibirLivroPorId() {
        return "Livro exibido com sucesso!";
    }

    //Alterar dados dos Livros (UPDATE)
    @PutMapping("/alterarLivroPorId")
    public String alterarLivroPorId() {
        return "Livro alterado com sucesso!";
    }

    //Deletar Livro (DELETE)
    @DeleteMapping("/deletarLivroPorId")
    public String deletarLivroPorId() {
        return "Livro deletado com sucesso!";
    }
}
