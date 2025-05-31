package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.CausaDTO;
import br.com.fiap.VIAF.Mapper.CausaMapper;
import br.com.fiap.VIAF.service.CausaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/causas")
@Validated
public class CausaController {

    private final CausaService service;
    private final CausaMapper mapper;

    public CausaController(CausaService service, CausaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CausaDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CausaDTO getById(@PathVariable @Positive Long id) {
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public CausaDTO create(@Valid @RequestBody CausaDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public CausaDTO update(@PathVariable @Positive Long id,
                           @Valid @RequestBody CausaDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        service.delete(id);
    }
}