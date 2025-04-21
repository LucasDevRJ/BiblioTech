package com.github.lucasdevrj.bibliotech.autor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping("/adicionar")
    public AutorModel adicionar(@RequestBody AutorModel autor) {
        return autorService.adicionarAutor(autor);
    }

    @GetMapping("/listar")
    public List<AutorModel> listar() {
        return autorService.listarTodoOsAutores();
    }

    @GetMapping("/exibirPorId/{id}")
    public AutorModel exibirPorId(@PathVariable Long id) {
        return autorService.exibirAutorPorId(id);
    }

    @PutMapping("/atualizarPorId/{id}")
    public AutorModel atualizarPorId(@PathVariable Long id, @RequestBody AutorModel autorAtualizado) {
        return autorService.atualizarAutorPorId(id, autorAtualizado);
    }

    @DeleteMapping("/deletarPorId/{id}")
    public void deletarPorId(@PathVariable Long id) {
        autorService.deletarAutorPorId(id);
    }
}
