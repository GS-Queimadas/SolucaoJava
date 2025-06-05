package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.RelatorioAcaoDTO;
import br.com.fiap.VIAF.Mapper.RelatorioAcaoMapper;
import br.com.fiap.VIAF.service.RelatorioAcaoService;
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
@RequestMapping("/api/relatorios-acao")
@Validated
@Tag(name = "Relatórios de Ação", description = "Endpoints para gerenciamento de relatórios de ação")
public class RelatorioAcaoController {

    private final RelatorioAcaoService service;
    private final RelatorioAcaoMapper mapper;

    public RelatorioAcaoController(RelatorioAcaoService service,
                                   RelatorioAcaoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Lista todos os relatórios de ação",
            description = "Retorna uma lista com todos os relatórios de ação cadastrados no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de relatórios de ação retornada com sucesso.")
    @GetMapping
    public List<RelatorioAcaoDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca um relatório de ação por ID",
            description = "Retorna os detalhes do relatório de ação correspondente ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relatório de ação encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Relatório de ação não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (deve ser um número positivo).")
    })
    @GetMapping("/{id}")
    public RelatorioAcaoDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @Operation(summary = "Cria um novo relatório de ação",
            description = "Registra um novo relatório de ação com base nos dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Relatório de ação criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para criação são inválidos (ex: campos obrigatórios faltando ou formato incorreto).")
    })
    @PostMapping
    public RelatorioAcaoDTO create(@Valid @RequestBody RelatorioAcaoDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Atualiza um relatório de ação existente",
            description = "Modifica os dados de um relatório de ação já existente, identificado pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relatório de ação atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Relatório de ação não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para atualização são inválidos ou o ID no path é inválido.")
    })
    @PutMapping("/{id}")
    public RelatorioAcaoDTO update(@PathVariable @Positive Long id,
                                   @Valid @RequestBody RelatorioAcaoDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Exclui um relatório de ação por ID",
            description = "Remove permanentemente um relatório de ação do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Relatório de ação excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Relatório de ação não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (deve ser um número positivo).")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}