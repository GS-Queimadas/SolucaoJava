package br.com.fiap.VIAF.Service;

import br.com.fiap.VIAF.DomainModel.Classe;
import br.com.fiap.VIAF.Repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    private final ClasseRepository repository;

    public ClasseService(ClasseRepository repository) {
        this.repository = repository;
    }

    public List<Classe> findAll() {
        return repository.findAll();
    }

    public Optional<Classe> findById(String id) {
        return repository.findById(id);
    }

    public Classe save(Classe classe) {
        return repository.save(classe);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}