package br.com.fiap.VIAF.Service;

import br.com.fiap.VIAF.DomainModel.Causa;
import br.com.fiap.VIAF.Repository.CausaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CausaService {

    private final CausaRepository repository;

    public CausaService(CausaRepository repository) {
        this.repository = repository;
    }

    public List<Causa> findAll() {
        return repository.findAll();
    }

    public Optional<Causa> findById(Long id) {
        return repository.findById(id);
    }

    public Causa save(Causa causa) {
        return repository.save(causa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}