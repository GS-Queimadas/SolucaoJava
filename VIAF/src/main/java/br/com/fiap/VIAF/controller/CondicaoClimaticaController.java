package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.CondicaoClimaticaDTO;
import br.com.fiap.VIAF.Mapper.CondicaoClimaticaMapper;
import br.com.fiap.VIAF.service.CondicaoClimaticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/condicoes-climaticas")
@Validated
@Tag(name = "Condições Climáticas", description = "Endpoints para gerenciamento de registros de condições climáticas")
public class CondicaoClimaticaController {

    private final CondicaoClimaticaService service;
    private final CondicaoClimaticaMapper mapper;

    public CondicaoClimaticaController(CondicaoClimaticaService service,
                                       CondicaoClimaticaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Lista todos os registros de condições climáticas",
            description = "Retorna uma lista com todos os registros de condições climáticas cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de condições climáticas retornada com sucesso.")
    @GetMapping
    public List<CondicaoClimaticaDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca um registro de condição climática por ID",
            description = "Retorna os detalhes do registro de condição climática correspondente ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro de condição climática encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Registro de condição climática não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (deve ser um número positivo).")
    })
    @GetMapping("/{id}")
    public CondicaoClimaticaDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @Operation(summary = "Cria um novo registro de condição climática",
            description = "Registra um novo conjunto de condições climáticas com base nos dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registro de condição climática criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para criação são inválidos (ex: campos obrigatórios faltando ou formato incorreto).")
    })
    @PostMapping
    public CondicaoClimaticaDTO create(@Valid @RequestBody CondicaoClimaticaDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Atualiza um registro de condição climática existente",
            description = "Modifica os dados de um registro de condição climática já existente, identificado pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro de condição climática atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Registro de condição climática não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para atualização são inválidos ou o ID no path é inválido.")
    })
    @PutMapping("/{id}")
    public CondicaoClimaticaDTO update(@PathVariable @Positive Long id,
                                       @Valid @RequestBody CondicaoClimaticaDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Exclui um registro de condição climática por ID",
            description = "Remove permanentemente um registro de condição climática do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Registro de condição climática excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Registro de condição climática não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (deve ser um número positivo).")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}