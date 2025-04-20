package com.github.lucasdevrj.bibliotech.autor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PostMapping("/adicionar")
    public String adicionar() {
        return "Autor adicionado com sucesso!";
    }

    @GetMapping("/listar")
    public String listar() {
        return "Autores listados com sucesso!";
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
