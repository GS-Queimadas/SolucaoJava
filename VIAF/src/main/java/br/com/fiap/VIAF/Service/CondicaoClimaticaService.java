package br.com.fiap.VIAF.Service;

import br.com.fiap.VIAF.DomainModel.CondicaoClimatica;
import br.com.fiap.VIAF.Repository.CondicaoClimaticaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicaoClimaticaService {

    private final CondicaoClimaticaRepository repository;

    public CondicaoClimaticaService(CondicaoClimaticaRepository repository) {
        this.repository = repository;
    }

    public List<CondicaoClimatica> findAll() {
        return repository.findAll();
    }

    public Optional<CondicaoClimatica> findById(Long id) {
        return repository.findById(id);
    }

    public CondicaoClimatica save(CondicaoClimatica condicao) {
        return repository.save(condicao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}