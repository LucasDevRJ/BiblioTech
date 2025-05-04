package com.github.lucasdevrj.bibliotech.autor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping("/adicionar")
    @Operation(summary = "Adiciona um novo autor", description = "Essa rota adiciona um novo autor no Banco de Dados.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Autor adicionado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao adicionar o autor.")
    })
    public ResponseEntity<String> adicionar(@Parameter(description = "Usuário encaminha os dados do Autor via requisição") @RequestBody AutorDTO autor) {
        autorService.adicionarAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Autor adicionado com sucesso!");
    }

    @GetMapping("/listar")
    @Operation(summary = "Listagem", description = "Listagem de autores adicionados.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Autor listado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao listar os autores.")
    })
    public ResponseEntity<List<AutorDTO>> autores() {
        List<AutorDTO> autores = autorService.listarTodoOsAutores();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/exibirPorId/{id}")
    @Operation(summary = "Exibi por ID", description = "Essa rota exibe as informações de um Autor pelo ID.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Autor exibido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir o autor.")
    })
    public ResponseEntity<?> exibirPorId(@Parameter(description = "Usuário encaminha o ID do autor") @PathVariable Long id) {
        AutorDTO autor = autorService.exibirAutorPorId(id);
        if (autor != null) {
            return ResponseEntity.ok(autor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor inexistente!");
        }
    }

    @PutMapping("/atualizarPorId/{id}")
    @Operation(summary = "Atualiza por ID", description = "Essa rota atualiza as informações de um Autor pelo ID.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Autor atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao atualizar o autor.")
    })
    public ResponseEntity<?> atualizarPorId(
            @Parameter(description = "Usuário encaminha o ID na URL da requisição.") @PathVariable Long id,
            @Parameter(description = "Usuário encaminha os novos dados via URL.") @RequestBody AutorDTO autorAtualizado
    ) {
        AutorDTO autor = autorService.atualizarAutorPorId(id, autorAtualizado);
        if (autor != null) {
            return ResponseEntity.ok(autor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor inexistente!");
        }
    }

    @DeleteMapping("/deletarPorId/{id}")
    @Operation(summary = "Deleção de Autor", description = "Deleta autor por ID via requisição.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Autor deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao deletar o autor.")
    })
    public ResponseEntity<String> deletarPorId(@Parameter(description = "Usuário encaminha o ID do autor a ser deletado") @PathVariable Long id) {
        if (autorService.exibirAutorPorId(id) != null) {
            autorService.deletarAutorPorId(id);
            return ResponseEntity.ok("Autor deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor inexistente!");
        }
    }
}
