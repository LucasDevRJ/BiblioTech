package com.github.lucasdevrj.bibliotech.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody AutorDTO autor) {
        autorService.adicionarAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Autor adicionado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AutorDTO>> autores() {
        List<AutorDTO> autores = autorService.listarTodoOsAutores();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/exibirPorId/{id}")
    public ResponseEntity<?> exibirPorId(@PathVariable Long id) {
        AutorDTO autor = autorService.exibirAutorPorId(id);
        if (autor != null) {
            return ResponseEntity.ok(autor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor inexistente!");
        }
    }

    @PutMapping("/atualizarPorId/{id}")
    public ResponseEntity<?> atualizarPorId(@PathVariable Long id, @RequestBody AutorDTO autorAtualizado) {
        AutorDTO autor = autorService.atualizarAutorPorId(id, autorAtualizado);
        if (autor != null) {
            return ResponseEntity.ok(autor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor inexistente!");
        }
    }

    @DeleteMapping("/deletarPorId/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        if (autorService.exibirAutorPorId(id) != null) {
            autorService.deletarAutorPorId(id);
            return ResponseEntity.ok("Autor deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor inexistente!");
        }
    }
}
