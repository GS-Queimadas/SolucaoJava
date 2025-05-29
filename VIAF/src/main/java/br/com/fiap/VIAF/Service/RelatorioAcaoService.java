package br.com.fiap.VIAF.Service;

import br.com.fiap.VIAF.DomainModel.RelatorioAcao;
import br.com.fiap.VIAF.Repository.RelatorioAcaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelatorioAcaoService {

    private final RelatorioAcaoRepository repository;

    public RelatorioAcaoService(RelatorioAcaoRepository repository) {
        this.repository = repository;
    }

    public List<RelatorioAcao> findAll() {
        return repository.findAll();
    }

    public Optional<RelatorioAcao> findById(Long id) {
        return repository.findById(id);
    }

    public RelatorioAcao save(RelatorioAcao relatorio) {
        return repository.save(relatorio);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}