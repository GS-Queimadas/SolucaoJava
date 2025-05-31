package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.DomainModel.OrgaoIncendioPK;
import br.com.fiap.VIAF.Dto.OrgaoIncendioDTO;
import br.com.fiap.VIAF.Mapper.OrgaoIncendioMapper;
import br.com.fiap.VIAF.service.OrgaoIncendioService;
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
public class OrgaoIncendioController {

    private final OrgaoIncendioService service;
    private final OrgaoIncendioMapper mapper;

    public OrgaoIncendioController(OrgaoIncendioService service,
                                   OrgaoIncendioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrgaoIncendioDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{incendioId}/{orgaoId}")
    public OrgaoIncendioDTO getById(@PathVariable @Positive Long incendioId,
                                    @PathVariable @Positive Long orgaoId) {
        var pk = new OrgaoIncendioPK(incendioId, orgaoId);
        return mapper.toDTO(service.findById(pk));
    }

    @PostMapping
    public OrgaoIncendioDTO create(@Valid @RequestBody OrgaoIncendioDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{incendioId}/{orgaoId}")
    public OrgaoIncendioDTO update(@PathVariable @Positive Long incendioId,
                                   @PathVariable @Positive Long orgaoId,
                                   @Valid @RequestBody OrgaoIncendioDTO dto) {
        dto.setIncendioId(incendioId);
        dto.setOrgaoId(orgaoId);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{incendioId}/{orgaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long incendioId,
                       @PathVariable @Positive Long orgaoId) {
        var pk = new OrgaoIncendioPK(incendioId, orgaoId);
        service.delete(pk);
    }
}