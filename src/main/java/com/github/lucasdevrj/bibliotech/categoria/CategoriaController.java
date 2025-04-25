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
    public CategoriaDTO adicionar(@RequestBody CategoriaDTO categoria) {
        return categoriaService.adicionarCategoria(categoria);
    }

    @GetMapping("/listar")
    public List<CategoriaDTO> listar() {
        return categoriaService.listarTodasAsCategorias();
    }

    @GetMapping("/exibirPorId/{id}")
        public CategoriaDTO exibirPorId(@PathVariable Long id) {
        return categoriaService.exibirCategoriaPorId(id);
    }

    @PutMapping("/atualizarPorId/{id}")
    public CategoriaDTO atualizarPorId(@PathVariable Long id, @RequestBody CategoriaDTO categoria) {
        return categoriaService.atualizarCategoriaPorId(id, categoria);
    }

    @DeleteMapping("/deletarPorId/{id}")
    public void deletarPorId(@PathVariable Long id) {
        categoriaService.deletarCategoriaPorId(id);
    }

}
