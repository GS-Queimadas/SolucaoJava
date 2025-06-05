package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.Dto.ClasseDTO;
import br.com.fiap.VIAF.Mapper.ClasseMapper;
import br.com.fiap.VIAF.service.ClasseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classes")
@Validated
public class ClasseController {

    private final ClasseService service;
    private final ClasseMapper mapper;

    public ClasseController(ClasseService service, ClasseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ClasseDTO> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClasseDTO getById(@PathVariable @Size(min = 1, max = 2) String id) {
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public ClasseDTO create(@Valid @RequestBody ClasseDTO dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ClasseDTO update(@PathVariable @Size(min = 1, max = 2) String id,
                            @Valid @RequestBody ClasseDTO dto) {
        dto.setId(id);
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Size(min = 1, max = 2) String id) {
        service.delete(id);
    }
}