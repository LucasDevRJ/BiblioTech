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

    @PostMapping("/adicionar")
    public LivroDTO adicionar(@RequestBody LivroDTO livroDTO) {
        return livroService.adicionarLivro(livroDTO);
    }

    @GetMapping("/listar")
    public List<LivroDTO> listar() {
        return livroService.listarTodosOsLivros();
    }

    @GetMapping("/exibirPorId/{id}")
    public LivroDTO exibirPorId(@PathVariable Long id) {
        return livroService.exibirLivroPorId(id);
    }

    @DeleteMapping("/deletarPorId/{id}")
    public void deletarPorId(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }

    @PutMapping("/atualizarPorId/{id}")
    public LivroDTO atualizar(@PathVariable Long id, @RequestBody LivroDTO livroAtualizado) {
        return livroService.atualizarLivroPorId(id, livroAtualizado);
    }
}
