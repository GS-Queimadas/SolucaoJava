package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.IncendioDTO;
import br.com.fiap.VIAF.Mapper.IncendioMapper;
import br.com.fiap.VIAF.service.IncendioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incendios")
@Validated
@Tag(name = "Incêndios", description = "Endpoints para gerenciamento de registros de incêndios")
public class IncendioController {

    private final IncendioService service;
    private final IncendioMapper mapper;

    @Autowired
    public IncendioController(IncendioService service, IncendioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Lista todos os registros de incêndios",
            description = "Retorna uma lista com todos os registros de incêndios cadastrados no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de incêndios retornada com sucesso.")
    @GetMapping
    public List<IncendioDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca um registro de incêndio por ID",
            description = "Retorna os detalhes do registro de incêndio correspondente ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro de incêndio encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Registro de incêndio não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (deve ser um número positivo).")
    })
    @GetMapping("/{id}")
    public IncendioDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @Operation(summary = "Cria um novo registro de incêndio",
            description = "Registra um novo incêndio com base nos dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registro de incêndio criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para criação são inválidos (ex: campos obrigatórios faltando ou formato incorreto).")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncendioDTO create(@Valid @RequestBody IncendioDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Atualiza um registro de incêndio existente",
            description = "Modifica os dados de um registro de incêndio já existente, identificado pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro de incêndio atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Registro de incêndio não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para atualização são inválidos ou o ID no path é inválido.")
    })
    @PutMapping("/{id}")
    public IncendioDTO update(@PathVariable @Positive Long id,
                              @Valid @RequestBody IncendioDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Exclui um registro de incêndio por ID",
            description = "Remove permanentemente um registro de incêndio do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Registro de incêndio excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Registro de incêndio não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (deve ser um número positivo).")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}