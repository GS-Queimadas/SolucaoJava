package br.com.fiap.VIAF.Service;

import br.com.fiap.VIAF.DomainModel.OrgaoIncendio;
import br.com.fiap.VIAF.DomainModel.OrgaoIncendioPK;
import br.com.fiap.VIAF.Repository.OrgaoIncendioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgaoIncendioService {

    private final OrgaoIncendioRepository repository;

    public OrgaoIncendioService(OrgaoIncendioRepository repository) {
        this.repository = repository;
    }

    public List<OrgaoIncendio> findAll() {
        return repository.findAll();
    }

    public Optional<OrgaoIncendio> findById(OrgaoIncendioPK id) {
        return repository.findById(id);
    }

    public OrgaoIncendio save(OrgaoIncendio oi) {
        return repository.save(oi);
    }

    public void delete(OrgaoIncendioPK id) {
        repository.deleteById(id);
    }
}
