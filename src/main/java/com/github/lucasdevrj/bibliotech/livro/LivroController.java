package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/bemvindo")
    public String displaysWelcomeMessage() {
        return "Seja bem-vindo a BiblioTech!";
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody LivroDTO livroDTO) {
        livroService.adicionarLivro(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livro adicionado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LivroDTO>> listar() {
        List<LivroDTO> livros = livroService.listarTodosOsLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/exibirPorId/{id}")
    public ResponseEntity<?> exibirPorId(@PathVariable Long id) {
        LivroDTO livro = livroService.exibirLivroPorId(id);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro inexistente!");
        }
    }

    @GetMapping("/exibirLivroPorTitulo/{titulo}")
    public ResponseEntity<?> exibirLivroPorTitulo(@PathVariable String titulo) {
        List<LivroDTO> livro = livroService.exibirLivroPorTitulo(titulo);
        if (livro.stream().findFirst().isPresent()) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro inexistente!");
        }
    }

    @GetMapping("/exibirLivroPorAutor/{autor}")
    public ResponseEntity<?> exibirLivroPorAutor(@PathVariable String autor) {
        List<LivroDTO> livro = livroService.exibirLivroPorAutor(autor);
        if (livro.stream().findFirst().isPresent()) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro inexistente!");
        }
    }

    @DeleteMapping("/deletarPorId/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        if (livroService.exibirLivroPorId(id) != null) {
            livroService.deletarLivro(id);
            return ResponseEntity.ok("Livro deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro inexistente!");
        }
    }

    @PutMapping("/atualizarPorId/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody LivroDTO livroAtualizado) {
        LivroDTO livro = livroService.atualizarLivroPorId(id, livroAtualizado);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro inexistente!");
        }
    }
}
