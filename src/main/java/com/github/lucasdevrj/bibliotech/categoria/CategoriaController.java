package com.github.lucasdevrj.bibliotech.categoria;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @PostMapping("/adicionar")
    public String adicionar() {
        return "Categoria adicionada com sucesso!";
    }

    @GetMapping("/listar")
    public String listar() {
        return "Categoria listada com sucesso!";
    }

    @GetMapping("/exibirPorId")
        public String exibirPorId() {
        return "Categoria exibida com sucesso!";
    }

    @PutMapping("/atualizarPorId")
    public String atualizarPorId() {
        return "Categoria atualizada com sucesso!";
    }

    @DeleteMapping("/deletarPorId")
    public String deletarPorId() {
        return "Categoria deletada com sucesso!";
    }

}
