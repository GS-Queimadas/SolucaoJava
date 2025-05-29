package br.com.fiap.VIAF.Controller;

import br.com.fiap.VIAF.DomainModel.OrgaoIncendio;
import br.com.fiap.VIAF.DomainModel.OrgaoIncendioPK;
import br.com.fiap.VIAF.Dto.OrgaoIncendioDTO;
import br.com.fiap.VIAF.Mapper.OrgaoIncendioMapper;
import br.com.fiap.VIAF.Service.OrgaoIncendioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orgaos-incendio")
public class OrgaoIncendioController {

    private final OrgaoIncendioService service;
    private final OrgaoIncendioMapper mapper;

    public OrgaoIncendioController(OrgaoIncendioService service, OrgaoIncendioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrgaoIncendioDTO> findAll() {
        return service.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{incendioId}/{orgaoId}")
    public ResponseEntity<OrgaoIncendioDTO> findById(
            @PathVariable Long incendioId,
            @PathVariable Long orgaoId) {

        OrgaoIncendioPK pk = new OrgaoIncendioPK(incendioId, orgaoId);
        return service.findById(pk)
                .map(entity -> ResponseEntity.ok(mapper.toDTO(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrgaoIncendioDTO> create(@Valid @RequestBody OrgaoIncendioDTO dto) {
        OrgaoIncendio saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{incendioId}/{orgaoId}")
    public ResponseEntity<OrgaoIncendioDTO> update(
            @PathVariable Long incendioId,
            @PathVariable Long orgaoId,
            @Valid @RequestBody OrgaoIncendioDTO dto) {

        dto.setIncendioId(incendioId);
        dto.setOrgaoId(orgaoId);
        OrgaoIncendio updated = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{incendioId}/{orgaoId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long incendioId,
            @PathVariable Long orgaoId) {

        OrgaoIncendioPK pk = new OrgaoIncendioPK(incendioId, orgaoId);
        service.delete(pk);
        return ResponseEntity.noContent().build();
    }
}