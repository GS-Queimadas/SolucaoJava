package br.com.fiap.VIAF.Service;

import br.com.fiap.VIAF.DomainModel.Incendio;
import br.com.fiap.VIAF.Repository.IncendioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncendioService {

    private final IncendioRepository repository;

    public IncendioService(IncendioRepository repository) {
        this.repository = repository;
    }

    public List<Incendio> findAll() {
        return repository.findAll();
    }

    public Optional<Incendio> findById(Long id) {
        return repository.findById(id);
    }

    public Incendio save(Incendio incendio) {
        return repository.save(incendio);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}