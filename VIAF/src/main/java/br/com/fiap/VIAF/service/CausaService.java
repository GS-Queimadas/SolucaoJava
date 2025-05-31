package br.com.fiap.VIAF.service;

import br.com.fiap.VIAF.DomainModel.Causa;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Repository.CausaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CausaService {

    private final CausaRepository repository;

    public CausaService(CausaRepository repository) {
        this.repository = repository;
    }

    public List<Causa> findAll() {
        return repository.findAll();
    }

    public Causa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Causa", id));
    }

    @Transactional
    public Causa save(Causa causa) {
        return repository.save(causa);
    }

    @Transactional
    public void delete(Long id) {
        // pode lançar ResourceNotFound se quiser verificar antes
        repository.deleteById(id);
    }
}