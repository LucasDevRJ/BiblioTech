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
    public String adicionar() {
        return "Autor adicionado com sucesso!";
    }

    @GetMapping("/listar")
    public List<AutorModel> listar() {
        return autorService.listarTodoOsAutores();
    }

    @GetMapping("/exibirPorId")
    public String exibirPorId() {
        return "Autor exibido com sucesso!";
    }

    @PutMapping("/atualizarPorId")
    public String atualizarPorId() {
        return "Autor atualizado com sucesso!";
    }

    @DeleteMapping("/deletarPorId")
    public String deletarPorId() {
        return "Autor deletado com sucesso!";
    }
}
