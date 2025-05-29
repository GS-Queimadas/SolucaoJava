package br.com.fiap.VIAF.Service;

import br.com.fiap.VIAF.DomainModel.OrgaoAtuacao;
import br.com.fiap.VIAF.Repository.OrgaoAtuacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgaoAtuacaoService {

    private final OrgaoAtuacaoRepository repository;

    public OrgaoAtuacaoService(OrgaoAtuacaoRepository repository) {
        this.repository = repository;
    }

    public List<OrgaoAtuacao> findAll() {
        return repository.findAll();
    }

    public Optional<OrgaoAtuacao> findById(Long id) {
        return repository.findById(id);
    }

    public OrgaoAtuacao save(OrgaoAtuacao orgao) {
        return repository.save(orgao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
