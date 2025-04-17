package com.github.lucasdevrj.bibliotech.livro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LivroController {

    @GetMapping("/welcome")
    public String displaysWelcomeMessage() {
        return "Seja bem-vindo a BiblioTech!";
    }
}
