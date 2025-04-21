package com.github.lucasdevrj.bibliotech.categoria;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/adicionar")
    public CategoriaModel adicionar(@RequestBody CategoriaModel categoria) {
        return categoriaService.adicionarCategoria(categoria);
    }

    @GetMapping("/listar")
    public List<CategoriaModel> listar() {
        return categoriaService.listarTodasAsCategorias();
    }

    @GetMapping("/exibirPorId/{id}")
        public CategoriaModel exibirPorId(@PathVariable Long id) {
        return categoriaService.exibirCategoriaPorId(id);
    }

    @PutMapping("/atualizarPorId/{id}")
    public CategoriaModel atualizarPorId(@PathVariable Long id, @RequestBody CategoriaModel categoria) {
        return categoriaService.atualizarCategoriaPorId(id, categoria);
    }

    @DeleteMapping("/deletarPorId/{id}")
    public void deletarPorId(@PathVariable Long id) {
        categoriaService.deletarCategoriaPorId(id);
    }

}
