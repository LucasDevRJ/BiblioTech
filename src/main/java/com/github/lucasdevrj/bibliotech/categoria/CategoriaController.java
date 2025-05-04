package com.github.lucasdevrj.bibliotech.categoria;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Adiciona Categoria", description = "Essa rota adiciona uma nova categoria no Banco de Dados.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Categoria adicionada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao adicionar a categoria.")
    })
    public ResponseEntity<String> adicionar(@Parameter(description = "Usuário encaminha os novos dados via URL") @RequestBody CategoriaDTO categoria) {
        categoriaService.adicionarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria adicionada com sucesso!");
    }

    @GetMapping("/listar")
    @Operation(summary = "Listagem", description = "Listagem de categorias adicionadas.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Categorias listadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao listar as categorias.")
    })
    public ResponseEntity<List<CategoriaDTO>> listar() {
        List<CategoriaDTO> categoriaDTOS = categoriaService.listarTodasAsCategorias();
        return ResponseEntity.ok(categoriaDTOS);
    }

    @GetMapping("/exibirPorId/{id}")
    @Operation(summary = "Exibir", description = "Exibi a Categoria passada via ID.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Categoria exibida com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir a categoria.")
    })
        public ResponseEntity<?> exibirPorId(@Parameter(description = "ID enviado via URL da requisição") @PathVariable Long id) {
        CategoriaDTO categoria = categoriaService.exibirCategoriaPorId(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria inexistente!");
        }
    }

    @PutMapping("/atualizarPorId/{id}")
    @Operation(summary = "Atualiza por ID", description = "Essa rota atualiza as informações de uma Categoria pelo ID.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao atualizar o Categoria.")
    })
    public ResponseEntity<?> atualizarPorId(
            @Parameter(description = "Usuário encaminha o ID na URL da requisição.") @PathVariable Long id,
            @Parameter(description = "Usuário encaminha os novos dados via URL.") @RequestBody CategoriaDTO categoriaDTO
    ) {
        CategoriaDTO categoria = categoriaService.atualizarCategoriaPorId(id, categoriaDTO);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria inexistente!");
        }
    }

    @DeleteMapping("/deletarPorId/{id}")
    @Operation(summary = "Deleção de Categoria", description = "Deleta categoria por ID via requisição.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Categoria deletada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao deletar a Categoria.")
    })
    public ResponseEntity<String> deletarPorId(@Parameter(description = "Usuário encaminha o ID do livro a ser deletado") @PathVariable Long id) {
        if (categoriaService.exibirCategoriaPorId(id) != null) {
            categoriaService.deletarCategoriaPorId(id);
            return ResponseEntity.ok("Categoria deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria inexistente!");
        }
    }
}
