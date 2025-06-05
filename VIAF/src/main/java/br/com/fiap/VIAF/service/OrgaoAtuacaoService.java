package br.com.fiap.VIAF.service;

import br.com.fiap.VIAF.DomainModel.OrgaoAtuacao;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Repository.OrgaoAtuacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrgaoAtuacaoService {

    private final OrgaoAtuacaoRepository repository;

    public OrgaoAtuacaoService(OrgaoAtuacaoRepository repository) {
        this.repository = repository;
    }

    public List<OrgaoAtuacao> findAll() {
        return repository.findAll();
    }

    public OrgaoAtuacao findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Órgão de Atuação", id));
    }

    @Transactional
    public OrgaoAtuacao save(OrgaoAtuacao orgao) {
        return repository.save(orgao);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
