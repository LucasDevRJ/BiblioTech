package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/welcome")
    public String displaysWelcomeMessage() {
        return "Seja bem-vindo a BiblioTech!";
    }

    //Adicionar Livro (CREATE)
    @PostMapping("/adicionar")
    public LivroModel adicionar(@RequestBody LivroModel livro) {
        return livroService.adicionarLivro(livro);
    }

    //Exibir todos os Livros (READ)
    @GetMapping("/listar")
    public List<LivroModel> listar() {
        return livroService.listarTodosOsLivros();
    }

    //Exibir Livro por ID (READ)
    @GetMapping("/exibirPorId/{id}")
    public LivroModel exibirPorId(@PathVariable Long id) {
        return livroService.exibirLivroPorId(id);
    }

    //Alterar dados dos Livros (UPDATE)
    @PutMapping("/atualizarPorId")
    public String atualizarPorId() {
        return "Livro atualizado com sucesso!";
    }

    //Deletar Livro (DELETE)
    @DeleteMapping("/deletarPorId/{id}")
    public void deletarPorId(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
}
