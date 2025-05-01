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
    public AutorDTO adicionar(@RequestBody AutorDTO autor) {
        return autorService.adicionarAutor(autor);
    }

    @GetMapping("/listar")
    public List<AutorDTO> listar() {
        return autorService.listarTodoOsAutores();
    }

    @GetMapping("/exibirPorId/{id}")
    public AutorDTO exibirPorId(@PathVariable Long id) {
        return autorService.exibirAutorPorId(id);
    }

    @PutMapping("/atualizarPorId/{id}")
    public AutorDTO atualizarPorId(@PathVariable Long id, @RequestBody AutorDTO autorAtualizado) {
        return autorService.atualizarAutorPorId(id, autorAtualizado);
    }

    @DeleteMapping("/deletarPorId/{id}")
    public void deletarPorId(@PathVariable Long id) {
        autorService.deletarAutorPorId(id);
    }
}
