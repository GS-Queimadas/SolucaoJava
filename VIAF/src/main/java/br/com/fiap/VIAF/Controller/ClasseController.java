package br.com.fiap.VIAF.Controller;

import br.com.fiap.VIAF.DomainModel.Classe;
import br.com.fiap.VIAF.Dto.ClasseDTO;
import br.com.fiap.VIAF.Mapper.ClasseMapper;
import br.com.fiap.VIAF.Service.ClasseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    private final ClasseService service;
    private final ClasseMapper mapper;

    public ClasseController(ClasseService service, ClasseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ClasseDTO> findAll() {
        return service.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDTO> findById(@PathVariable String id) {
        return service.findById(id)
                .map(entity -> ResponseEntity.ok(mapper.toDTO(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClasseDTO> create(@Valid @RequestBody ClasseDTO dto) {
        Classe saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasseDTO> update(@PathVariable String id, @Valid @RequestBody ClasseDTO dto) {
        dto.setId(id);
        Classe updated = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}