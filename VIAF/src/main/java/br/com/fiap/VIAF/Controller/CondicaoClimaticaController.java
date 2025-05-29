package br.com.fiap.VIAF.Controller;

import br.com.fiap.VIAF.DomainModel.CondicaoClimatica;
import br.com.fiap.VIAF.Dto.CondicaoClimaticaDTO;
import br.com.fiap.VIAF.Mapper.CondicaoClimaticaMapper;
import br.com.fiap.VIAF.Service.CondicaoClimaticaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/condicoes-climaticas")
public class CondicaoClimaticaController {

    private final CondicaoClimaticaService service;
    private final CondicaoClimaticaMapper mapper;

    public CondicaoClimaticaController(CondicaoClimaticaService service, CondicaoClimaticaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CondicaoClimaticaDTO> findAll() {
        return service.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicaoClimaticaDTO> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(entity -> ResponseEntity.ok(mapper.toDTO(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CondicaoClimaticaDTO> create(@Valid @RequestBody CondicaoClimaticaDTO dto) {
        CondicaoClimatica saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicaoClimaticaDTO> update(@PathVariable Long id, @Valid @RequestBody CondicaoClimaticaDTO dto) {
        dto.setId(id);
        CondicaoClimatica updated = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}