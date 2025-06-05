package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.ClasseDTO;
import br.com.fiap.VIAF.Mapper.ClasseMapper;
import br.com.fiap.VIAF.service.ClasseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classes")
@Validated
@Tag(name = "Classes de Incêndio", description = "Endpoints para gerenciamento de classes de incêndio")
public class ClasseController {

    private final ClasseService service;
    private final ClasseMapper mapper;

    public ClasseController(ClasseService service, ClasseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Lista todas as classes de incêndio",
            description = "Retorna uma lista com todas as classes de incêndio cadastradas no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de classes retornada com sucesso.")
    @GetMapping
    public List<ClasseDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca uma classe de incêndio por ID",
            description = "Retorna os detalhes da classe de incêndio correspondente ao ID fornecido (String de 1 a 2 caracteres).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe de incêndio encontrada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Classe de incêndio não encontrada para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (não atende ao tamanho esperado de 1 a 2 caracteres).")
    })
    @GetMapping("/{id}")
    public ClasseDTO getById(@PathVariable @Size(min = 1, max = 2) String id) {
        return mapper.toDTO(service.findById(id));
    }

    @Operation(summary = "Cria uma nova classe de incêndio",
            description = "Registra uma nova classe de incêndio com base nos dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Classe de incêndio criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para criação são inválidos (ex: campos obrigatórios faltando ou formato incorreto).")
    })
    @PostMapping
    public ClasseDTO create(@Valid @RequestBody ClasseDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Atualiza uma classe de incêndio existente",
            description = "Modifica os dados de uma classe de incêndio já existente, identificada pelo ID (String de 1 a 2 caracteres).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe de incêndio atualizada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Classe de incêndio não encontrada para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para atualização são inválidos ou o ID no path é inválido.")
    })
    @PutMapping("/{id}")
    public ClasseDTO update(@PathVariable @Size(min = 1, max = 2) String id,
                            @Valid @RequestBody ClasseDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Exclui uma classe de incêndio por ID",
            description = "Remove permanentemente uma classe de incêndio do sistema com base no ID fornecido (String de 1 a 2 caracteres).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Classe de incêndio excluída com sucesso."),
            @ApiResponse(responseCode = "404", description = "Classe de incêndio não encontrada para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido.")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Size(min = 1, max = 2) String id) {
        service.delete(id);
    }
}