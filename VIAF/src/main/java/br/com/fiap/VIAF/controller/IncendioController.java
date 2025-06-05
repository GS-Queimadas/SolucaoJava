package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.IncendioDTO;
import br.com.fiap.VIAF.Mapper.IncendioMapper;
import br.com.fiap.VIAF.service.IncendioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incendios")
@Validated
public class IncendioController {

    private final IncendioService service;
    private final IncendioMapper mapper;

    public IncendioController(IncendioService service, IncendioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<IncendioDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public IncendioDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public IncendioDTO create(@Valid @RequestBody IncendioDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public IncendioDTO update(@PathVariable @Positive Long id,
                              @Valid @RequestBody IncendioDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}