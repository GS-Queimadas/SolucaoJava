package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.CondicaoClimaticaDTO;
import br.com.fiap.VIAF.Mapper.CondicaoClimaticaMapper;
import br.com.fiap.VIAF.service.CondicaoClimaticaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/condicoes-climaticas")
@Validated
public class CondicaoClimaticaController {

    private final CondicaoClimaticaService service;
    private final CondicaoClimaticaMapper mapper;

    public CondicaoClimaticaController(CondicaoClimaticaService service,
                                       CondicaoClimaticaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CondicaoClimaticaDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CondicaoClimaticaDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public CondicaoClimaticaDTO create(@Valid @RequestBody CondicaoClimaticaDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public CondicaoClimaticaDTO update(@PathVariable @Positive Long id,
                                       @Valid @RequestBody CondicaoClimaticaDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}