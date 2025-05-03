package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/listarLivrosPorTitulo/{titulo}")
    public ResponseEntity<?> listarLivrosPorTitulo(@PathVariable String titulo) {
        List<LivroDTO> livro = livroService.listarLivrosPorTitulo(titulo);
        if (livro.stream().findFirst().isPresent()) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há livros cadastrados com esse titulo!");
        }
    }

    @GetMapping("/listarLivrosPorAutor/{autor}")
    public ResponseEntity<?> listarLivrosPorAutor(@PathVariable String autor) {
        List<LivroDTO> livro = livroService.listarLivrosPorAutor(autor);
        if (livro.stream().findFirst().isPresent()) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há livros cadastrados com esse autor!");
        }
    }

    @GetMapping("/listarLivrosPorCategoria/{categoria}")
    public ResponseEntity<?> listarLivrosPorCategoria(@PathVariable String categoria) {
        List<LivroDTO> livro = livroService.listarLivrosPorCategoria(categoria);
        if (livro.stream().findFirst().isPresent()) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há livros cadastrados com esse categoria!");
        }
    }

    @GetMapping("/listarLivrosPorDatas/{dataInicio}/{dataFim}")
    public ResponseEntity<?> listarLivrosPorCategoria(@PathVariable LocalDate dataInicio, @PathVariable LocalDate dataFim) {
        List<LivroDTO> livro = livroService.listarLivrosPorDatas(dataInicio, dataFim);
        return ResponseEntity.ok(livro);
    }

    @GetMapping("/listarLivrosComOrdenacao")
    public ResponseEntity<Page<LivroDTO>> listarLivros(Pageable pageable) {
        Page<LivroDTO> livros = livroService.listarLivrosComOrdenacao(pageable);
        return ResponseEntity.ok(livros);
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

    @GetMapping("/exibeQuantidadeDeLivrosCadastrados")
    public ResponseEntity<String> exibeTotalDeLivrosCadastrados() {
        long livros = livroService.exibeQuantidadeDeLivrosCadastrados();
        if (livros == 0) {
            return ResponseEntity.ok("Não há livros cadastrados!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("A quantidade de livros cadastrados é " + livros);
        }
    }
}
