package com.github.lucasdevrj.bibliotech.livro;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/bemvindo")
    @Operation(summary = "Mensagem de boas-vindas", description = "Essa rota dá boas-vindas para quem a acessa.")
    public String displaysWelcomeMessage() {
        return "Seja bem-vindo a BiblioTech!";
    }

    @PostMapping("/adicionar")
    @Operation(summary = "Adiciona um novo livro", description = "Essa rota adiciona um novo livro no Banco de Dados.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Livro adicionado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao adicionar o livro.")
    })
    public ResponseEntity<String> adicionar(
            @Parameter(description = "Usuário encaminha os dados do Livro via requisição") @RequestBody LivroDTO livroDTO
    ) {
        livroService.adicionarLivro(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livro adicionado com sucesso!");
    }

    @GetMapping("/listar")
    @Operation(summary = "Listagem", description = "Listagem de livros adicionados.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livro listado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao listar os livros.")
    })
    public ResponseEntity<List<LivroDTO>> listar() {
        List<LivroDTO> livros = livroService.listarTodosOsLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/exibirPorId/{id}")
    @Operation(summary = "Exibi por ID", description = "Essa rota exibe as informações de um Livro pelo ID.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livro exibido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir o livro.")
    })
    public ResponseEntity<?> exibirPorId(@Parameter(description = "Usuário encaminha o ID do livro") @PathVariable Long id) {
        LivroDTO livro = livroService.exibirLivroPorId(id);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro inexistente!");
        }
    }

    @GetMapping("/listarLivrosPorTitulo/{titulo}")
    @Operation(summary = "Exibi Livro", description = "Exibi livro pelo título dele passado via requisição.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livro exibido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir o livro.")
    })
    public ResponseEntity<?> listarLivrosPorTitulo(@Parameter(description = "Usuário encaminha o Titulo do livro") @PathVariable String titulo) {
        List<LivroDTO> livro = livroService.listarLivrosPorTitulo(titulo);
        if (livro.stream().findFirst().isPresent()) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há livros cadastrados com esse titulo!");
        }
    }

    @GetMapping("/listarLivrosPorAutor/{autor}")
    @Operation(summary = "Exibi Livro", description = "Exibi livro pelo autor dele passado via requisição.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livro exibido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir o livro.")
    })
    public ResponseEntity<?> listarLivrosPorAutor(@Parameter(description = "Usuário encaminha o Autor do livro") @PathVariable String autor) {
        List<LivroDTO> livro = livroService.listarLivrosPorAutor(autor);
        if (livro.stream().findFirst().isPresent()) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há livros cadastrados com esse autor!");
        }
    }

    @GetMapping("/listarLivrosPorCategoria/{categoria}")
    @Operation(summary = "Exibi Livro", description = "Exibi livro pela Categoria dele passado via requisição.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livro exibido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir o livro.")
    })
    public ResponseEntity<?> listarLivrosPorCategoria(@PathVariable String categoria) {
        List<LivroDTO> livro = livroService.listarLivrosPorCategoria(categoria);
        if (livro.stream().findFirst().isPresent()) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há livros cadastrados com esse categoria!");
        }
    }

    @GetMapping("/listarLivrosPorDatas/{dataInicio}/{dataFim}")
    @Operation(summary = "Exibi Livro", description = "Exibi livro pelas datas dele passado via requisição.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livro exibido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir o livro.")
    })
    public ResponseEntity<?> listarLivrosPorCategoria(
            @Parameter(description = "Data de início") @PathVariable LocalDate dataInicio,
            @Parameter(description = "Data de fim") @PathVariable LocalDate dataFim
    ) {
        List<LivroDTO> livro = livroService.listarLivrosPorDatas(dataInicio, dataFim);
        return ResponseEntity.ok(livro);
    }

    @GetMapping("/listarLivrosComOrdenacao")
    @Operation(summary = "Listagem de Livros", description = "Lista livros ordenados via requisição.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livros listados com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao listar os livros.")
    })
    public ResponseEntity<Page<LivroDTO>> listarLivros(@Parameter(description = "Tipo de ordenação") Pageable pageable) {
        Page<LivroDTO> livros = livroService.listarLivrosComOrdenacao(pageable);
        return ResponseEntity.ok(livros);
    }

    @DeleteMapping("/deletarPorId/{id}")
    @Operation(summary = "Deleção de Livro", description = "Deleta livro por ID via requisição.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livro deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao deletar o livro.")
    })
    public ResponseEntity<String> deletarPorId(@Parameter(description = "Usuário encaminha o ID do livro a ser deletado") @PathVariable Long id) {
        if (livroService.exibirLivroPorId(id) != null) {
            livroService.deletarLivro(id);
            return ResponseEntity.ok("Livro deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro inexistente!");
        }
    }

    @PutMapping("/atualizarPorId/{id}")
    @Operation(summary = "Atualiza por ID", description = "Essa rota atualiza as informações de um Livro pelo ID.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao atualizar o livro.")
    })
    public ResponseEntity<?> atualizar(
            @Parameter(description = "Usuário encaminha o ID na URL da requisição.") @PathVariable Long id,
            @Parameter(description = "Usuário encaminha os novos dados via URL.") @RequestBody LivroDTO livroAtualizado) {
        LivroDTO livro = livroService.atualizarLivroPorId(id, livroAtualizado);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro inexistente!");
        }
    }

    @GetMapping("/exibeQuantidadeDeLivrosCadastrados")
    @Operation(summary = "Exibe quantidade", description = "Exibe a quantidade de livros cadastrados.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Quantidade exibida com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir a quantidade.")
    })
    public ResponseEntity<String> exibeTotalDeLivrosCadastrados() {
        long livros = livroService.exibeQuantidadeDeLivrosCadastrados();
        if (livros == 0) {
            return ResponseEntity.ok("Não há livros cadastrados!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("A quantidade de livros cadastrados é " + livros);
        }
    }
}
