package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.OrgaoAtuacaoDTO;
import br.com.fiap.VIAF.Mapper.OrgaoAtuacaoMapper;
import br.com.fiap.VIAF.service.OrgaoAtuacaoService;
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
public class OrgaoAtuacaoController {

    private final OrgaoAtuacaoService service;
    private final OrgaoAtuacaoMapper mapper;

    public OrgaoAtuacaoController(OrgaoAtuacaoService service,
                                  OrgaoAtuacaoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrgaoAtuacaoDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrgaoAtuacaoDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public OrgaoAtuacaoDTO create(@Valid @RequestBody OrgaoAtuacaoDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public OrgaoAtuacaoDTO update(@PathVariable @Positive Long id,
                                  @Valid @RequestBody OrgaoAtuacaoDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}