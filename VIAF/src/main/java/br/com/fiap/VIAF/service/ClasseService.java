package br.com.fiap.VIAF.service;

import br.com.fiap.VIAF.DomainModel.Classe;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Repository.ClasseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ClasseService {

    private final ClasseRepository repository;

    public ClasseService(ClasseRepository repository) {
        this.repository = repository;
    }

    public List<Classe> findAll() {
        return repository.findAll();
    }

    public Classe findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classe", id));
    }

    @Transactional
    public Classe save(Classe classe) {
        return repository.save(classe);
    }

    @Transactional
    public void delete(String id) {
        repository.deleteById(id);
    }
}