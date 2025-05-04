package com.github.lucasdevrj.bibliotech.categoria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody CategoriaDTO categoria) {
        categoriaService.adicionarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria adicionada com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaDTO>> listar() {
        List<CategoriaDTO> categoriaDTOS = categoriaService.listarTodasAsCategorias();
        return ResponseEntity.ok(categoriaDTOS);
    }

    @GetMapping("/exibirPorId/{id}")
        public ResponseEntity<?> exibirPorId(@PathVariable Long id) {
        CategoriaDTO categoria = categoriaService.exibirCategoriaPorId(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria inexistente!");
        }
    }

    @PutMapping("/atualizarPorId/{id}")
    public ResponseEntity<?> atualizarPorId(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO categoria = categoriaService.atualizarCategoriaPorId(id, categoriaDTO);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria inexistente!");
        }
    }

    @DeleteMapping("/deletarPorId/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        if (categoriaService.exibirCategoriaPorId(id) != null) {
            categoriaService.deletarCategoriaPorId(id);
            return ResponseEntity.ok("Categoria deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria inexistente!");
        }
    }
}
