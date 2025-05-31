package br.com.fiap.VIAF.service;

import br.com.fiap.VIAF.DomainModel.CondicaoClimatica;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Repository.CondicaoClimaticaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CondicaoClimaticaService {

    private final CondicaoClimaticaRepository repository;

    public CondicaoClimaticaService(CondicaoClimaticaRepository repository) {
        this.repository = repository;
    }

    public List<CondicaoClimatica> findAll() {
        return repository.findAll();
    }

    public CondicaoClimatica findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Condição Climática", id));
    }

    @Transactional
    public CondicaoClimatica save(CondicaoClimatica condicao) {
        return repository.save(condicao);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}