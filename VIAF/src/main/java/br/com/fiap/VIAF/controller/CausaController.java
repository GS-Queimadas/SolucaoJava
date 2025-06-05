package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.CausaDTO;
import br.com.fiap.VIAF.Mapper.CausaMapper;
import br.com.fiap.VIAF.service.CausaService;
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
@RequestMapping("/api/causas")
@Validated
@Tag(name = "Causa Queimadas", description = "Endpoints para gerenciamento de registros da causa das queimadas")
public class CausaController {

    private final CausaService service;
    private final CausaMapper mapper;

    public CausaController(CausaService service, CausaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Listar todas as causas", description = "Retorna uma lista paginada (ou completa) de CausaDTO")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping
    public List<CausaDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca uma causa por ID",
            description = "Retorna a causa cujo ID foi fornecido")
    @ApiResponse(responseCode = "200", description = "Causa encontrada")
    @ApiResponse(responseCode = "404", description = "Causa não encontrada")
    @GetMapping("/{id}")
    public CausaDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @Operation(summary = "Cria uma nova causa")
    @ApiResponse(responseCode = "200", description = "Causa criada")
    @PostMapping
    public CausaDTO create(@Valid @RequestBody CausaDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Atualiza uma causa existente.",
            description = "Atualiza os dados de uma causa existente com base no ID fornecido e nos novos dados no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Causa atualizada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Causa não encontrada para atualização."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida devido a dados incorretos para atualização.")
    })
    @PutMapping("/{id}")
    public CausaDTO update(@PathVariable @Positive Long id,
                           @Valid @RequestBody CausaDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @Operation(summary = "Exclui uma causa por ID.",
            description = "Remove uma causa do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Causa excluída com sucesso."),
            @ApiResponse(responseCode = "404", description = "Causa não encontrada para exclusão.")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}