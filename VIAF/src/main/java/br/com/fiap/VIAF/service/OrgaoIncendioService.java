package br.com.fiap.VIAF.service;

import br.com.fiap.VIAF.DomainModel.OrgaoIncendio;
import br.com.fiap.VIAF.DomainModel.OrgaoIncendioPK;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Repository.OrgaoIncendioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrgaoIncendioService {

    private final OrgaoIncendioRepository repository;

    public OrgaoIncendioService(OrgaoIncendioRepository repository) {
        this.repository = repository;
    }

    public List<OrgaoIncendio> findAll() {
        return repository.findAll();
    }

    public OrgaoIncendio findById(OrgaoIncendioPK pk) {
        return repository.findById(pk)
                .orElseThrow(() -> new ResourceNotFoundException("Ligação Órgão–Incêndio", pk));
    }

    @Transactional
    public OrgaoIncendio save(OrgaoIncendio oi) {
        return repository.save(oi);
    }

    @Transactional
    public void delete(OrgaoIncendioPK pk) {
        repository.deleteById(pk);
    }
}
