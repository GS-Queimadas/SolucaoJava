package br.com.fiap.VIAF.Controller;

import br.com.fiap.VIAF.DomainModel.Incendio;
import br.com.fiap.VIAF.Service.IncendioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incendios")
public class IncendioController {
    private final IncendioService service;

    public IncendioController(IncendioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Incendio> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incendio> buscarPorId(@PathVariable Long id) {
        Incendio incendio = service.buscarPorId(id);
        return ResponseEntity.ok(incendio);
    }

    @PostMapping
    public ResponseEntity<Incendio> salvar(@RequestBody @Valid Incendio incendio) {
        return ResponseEntity.status(201).body(service.salvar(incendio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incendio> atualizar(@PathVariable Long id, @RequestBody @Valid Incendio dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ano/{ano}")
    public ResponseEntity<List<Incendio>> buscarPorAno(@PathVariable Integer ano) {
        return ResponseEntity.ok(service.buscarPorAno(ano));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Incendio>> buscarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

    @GetMapping("/causa/{idCausa}")
    public ResponseEntity<List<Incendio>> buscarPorCausa(@PathVariable Long idCausa) {
        return ResponseEntity.ok(service.buscarPorCausa(idCausa));
    }
}
