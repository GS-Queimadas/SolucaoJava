package br.com.fiap.VIAF.Controller;

import br.com.fiap.VIAF.DomainModel.Causa;
import br.com.fiap.VIAF.Dto.CausaDTO;
import br.com.fiap.VIAF.Mapper.CausaMapper;
import br.com.fiap.VIAF.Service.CausaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/causas")
public class CausaController {

    private final CausaService service;
    private final CausaMapper mapper;

    public CausaController(CausaService service, CausaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CausaDTO> findAll() {
        return service.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CausaDTO> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(entity -> ResponseEntity.ok(mapper.toDTO(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CausaDTO> create(@Valid @RequestBody CausaDTO dto) {
        Causa saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CausaDTO> update(@PathVariable Long id, @Valid @RequestBody CausaDTO dto) {
        dto.setId(id);
        Causa updated = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}