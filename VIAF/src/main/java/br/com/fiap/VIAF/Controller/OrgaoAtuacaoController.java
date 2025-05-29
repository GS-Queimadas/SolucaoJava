package br.com.fiap.VIAF.Controller;

import br.com.fiap.VIAF.DomainModel.OrgaoAtuacao;
import br.com.fiap.VIAF.Dto.OrgaoAtuacaoDTO;
import br.com.fiap.VIAF.Mapper.OrgaoAtuacaoMapper;
import br.com.fiap.VIAF.Service.OrgaoAtuacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orgaos-atuacao")
public class OrgaoAtuacaoController {

    private final OrgaoAtuacaoService service;
    private final OrgaoAtuacaoMapper mapper;

    public OrgaoAtuacaoController(OrgaoAtuacaoService service, OrgaoAtuacaoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrgaoAtuacaoDTO> findAll() {
        return service.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgaoAtuacaoDTO> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(entity -> ResponseEntity.ok(mapper.toDTO(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrgaoAtuacaoDTO> create(@Valid @RequestBody OrgaoAtuacaoDTO dto) {
        OrgaoAtuacao saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrgaoAtuacaoDTO> update(@PathVariable Long id, @Valid @RequestBody OrgaoAtuacaoDTO dto) {
        dto.setId(id);
        OrgaoAtuacao updated = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
