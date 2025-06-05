package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.OrgaoAtuacaoDTO;
import br.com.fiap.VIAF.Mapper.OrgaoAtuacaoMapper;
import br.com.fiap.VIAF.service.OrgaoAtuacaoService;
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
@RequestMapping("/api/orgaos-atuacao")
@Validated
@Tag(name = "Órgãos de Atuação", description = "Endpoints para gerenciamento de órgãos de atuação")
public class OrgaoAtuacaoController {

    private final OrgaoAtuacaoService service;
    private final OrgaoAtuacaoMapper mapper;

    public OrgaoAtuacaoController(OrgaoAtuacaoService service,
                                  OrgaoAtuacaoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Lista todos os órgãos de atuação",
            description = "Retorna uma lista com todos os órgãos de atuação cadastrados no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de órgãos de atuação retornada com sucesso.")
    @GetMapping
    public List<OrgaoAtuacaoDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca um órgão de atuação por ID",
            description = "Retorna os detalhes do órgão de atuação correspondente ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Órgão de atuação encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Órgão de atuação não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (deve ser um número positivo).")
    })
    @GetMapping("/{id}")
    public OrgaoAtuacaoDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }


    @Operation(summary = "Cria um novo órgão de atuação",
            description = "Registra um novo órgão de atuação com base nos dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Órgão de atuação criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para criação são inválidos (ex: campos obrigatórios faltando ou formato incorreto).")
    })
    @PostMapping
    public OrgaoAtuacaoDTO create(@Valid @RequestBody OrgaoAtuacaoDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Atualiza um órgão de atuação existente",
            description = "Modifica os dados de um órgão de atuação já existente, identificado pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Órgão de atuação atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Órgão de atuação não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para atualização são inválidos ou o ID no path é inválido.")
    })
    @PutMapping("/{id}")
    public OrgaoAtuacaoDTO update(@PathVariable @Positive Long id,
                                  @Valid @RequestBody OrgaoAtuacaoDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Exclui um órgão de atuação por ID",
            description = "Remove permanentemente um órgão de atuação do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Órgão de atuação excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Órgão de atuação não encontrado para o ID fornecido."),
            @ApiResponse(responseCode = "400", description = "ID fornecido é inválido (deve ser um número positivo).")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}