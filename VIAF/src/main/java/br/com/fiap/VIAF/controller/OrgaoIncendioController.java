package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.DomainModel.OrgaoIncendioPK;
import br.com.fiap.VIAF.Dto.OrgaoIncendioDTO;
import br.com.fiap.VIAF.Mapper.OrgaoIncendioMapper;
import br.com.fiap.VIAF.service.OrgaoIncendioService;
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
@RequestMapping("/api/orgaos-incendio")
@Validated
@Tag(name = "Atuação de Órgãos em Incêndios", description = "Endpoints para gerenciar a relação de atuação de órgãos específicos em incêndios")
public class OrgaoIncendioController {

    private final OrgaoIncendioService service;
    private final OrgaoIncendioMapper mapper;

    public OrgaoIncendioController(OrgaoIncendioService service,
                                   OrgaoIncendioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Lista todas as atuações de órgãos em incêndios",
            description = "Retorna uma lista de todas as associações registradas entre órgãos de atuação e incêndios.")
    @ApiResponse(responseCode = "200", description = "Lista de atuações retornada com sucesso.")
    @GetMapping
    public List<OrgaoIncendioDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca uma atuação específica de órgão em incêndio por IDs",
            description = "Retorna os detalhes da atuação de um órgão em um incêndio, identificados pelo ID do incêndio e ID do órgão.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atuação encontrada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Atuação não encontrada para os IDs fornecidos."),
            @ApiResponse(responseCode = "400", description = "IDs fornecidos são inválidos (devem ser números positivos).")
    })
    @GetMapping("/{incendioId}/{orgaoId}")
    public OrgaoIncendioDTO getById(@PathVariable @Positive Long incendioId,
                                    @PathVariable @Positive Long orgaoId) {
        var pk = new OrgaoIncendioPK(incendioId, orgaoId);
        return mapper.toDTO(service.findById(pk));
    }

    @Operation(summary = "Registra a atuação de um órgão em um incêndio",
            description = "Cria uma nova associação entre um órgão e um incêndio, detalhando a atuação. Os IDs do incêndio e do órgão devem estar presentes no corpo da requisição (DTO).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atuação registrada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para registro são inválidos (ex: IDs faltando no DTO, ou dados de atuação incorretos).")
    })
    @PostMapping
    public OrgaoIncendioDTO create(@Valid @RequestBody OrgaoIncendioDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Atualiza os dados da atuação de um órgão em um incêndio",
            description = "Modifica os detalhes da atuação de um órgão em um incêndio, identificada pelo ID do incêndio e ID do órgão. Os novos dados são fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atuação atualizada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Atuação não encontrada para os IDs fornecidos."),
            @ApiResponse(responseCode = "400", description = "Dados fornecidos para atualização são inválidos ou os IDs na URL são inválidos.")
    })
    @PutMapping("/{incendioId}/{orgaoId}")
    public OrgaoIncendioDTO update(@PathVariable @Positive Long incendioId,
                                   @PathVariable @Positive Long orgaoId,
                                   @Valid @RequestBody OrgaoIncendioDTO dto) {
        dto.setIncendioId(incendioId);
        dto.setOrgaoId(orgaoId);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Exclui a atuação de um órgão em um incêndio",
            description = "Remove permanentemente o registro da atuação de um órgão em um incêndio, com base no ID do incêndio e ID do órgão.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Atuação excluída com sucesso."),
            @ApiResponse(responseCode = "404", description = "Atuação não encontrada para os IDs fornecidos."),
            @ApiResponse(responseCode = "400", description = "IDs fornecidos são inválidos (devem ser números positivos).")
    })
    @DeleteMapping("/{incendioId}/{orgaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long incendioId,
                       @PathVariable @Positive Long orgaoId) {
        var pk = new OrgaoIncendioPK(incendioId, orgaoId);
        service.delete(pk);
    }
}