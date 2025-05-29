package br.com.fiap.VIAF.Controller;

import br.com.fiap.VIAF.DomainModel.RelatorioAcao;
import br.com.fiap.VIAF.Dto.RelatorioAcaoDTO;
import br.com.fiap.VIAF.Mapper.RelatorioAcaoMapper;
import br.com.fiap.VIAF.Service.RelatorioAcaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/relatorios-acao")
public class RelatorioAcaoController {

    private final RelatorioAcaoService service;
    private final RelatorioAcaoMapper mapper;

    public RelatorioAcaoController(RelatorioAcaoService service, RelatorioAcaoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<RelatorioAcaoDTO> findAll() {
        return service.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelatorioAcaoDTO> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(entity -> ResponseEntity.ok(mapper.toDTO(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RelatorioAcaoDTO> create(@Valid @RequestBody RelatorioAcaoDTO dto) {
        RelatorioAcao saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelatorioAcaoDTO> update(@PathVariable Long id, @Valid @RequestBody RelatorioAcaoDTO dto) {
        dto.setId(id);
        RelatorioAcao updated = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}