package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @GetMapping("/welcome")
    public String displaysWelcomeMessage() {
        return "Seja bem-vindo a BiblioTech!";
    }

    //Adicionar Livro (CREATE)
    @PostMapping("/adicionar")
    public String adicionar() {
        return "Livro adicionado com sucesso!";
    }

    //Exibir todos os Livros (READ)
    @GetMapping("/listar")
    public String listar() {
        return "Livros listados com sucesso!";
    }

    //Exibir Livro por ID (READ)
    @GetMapping("/exibirPorId")
    public String exibirPorId() {
        return "Livro exibido com sucesso!";
    }

    //Alterar dados dos Livros (UPDATE)
    @PutMapping("/atualizarPorId")
    public String atualizarPorId() {
        return "Livro atualizado com sucesso!";
    }

    //Deletar Livro (DELETE)
    @DeleteMapping("/deletarPorId")
    public String deletarPorId() {
        return "Livro deletado com sucesso!";
    }
}
