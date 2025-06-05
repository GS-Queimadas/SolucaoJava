package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.RelatorioAcaoDTO;
import br.com.fiap.VIAF.Mapper.RelatorioAcaoMapper;
import br.com.fiap.VIAF.service.RelatorioAcaoService;
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
public class RelatorioAcaoController {

    private final RelatorioAcaoService service;
    private final RelatorioAcaoMapper mapper;

    public RelatorioAcaoController(RelatorioAcaoService service,
                                   RelatorioAcaoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<RelatorioAcaoDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RelatorioAcaoDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public RelatorioAcaoDTO create(@Valid @RequestBody RelatorioAcaoDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public RelatorioAcaoDTO update(@PathVariable @Positive Long id,
                                   @Valid @RequestBody RelatorioAcaoDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}