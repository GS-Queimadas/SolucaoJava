package br.com.fiap.VIAF.service;

import br.com.fiap.VIAF.DomainModel.RelatorioAcao;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Repository.RelatorioAcaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RelatorioAcaoService {

    private final RelatorioAcaoRepository repository;

    public RelatorioAcaoService(RelatorioAcaoRepository repository) {
        this.repository = repository;
    }

    public List<RelatorioAcao> findAll() {
        return repository.findAll();
    }

    public RelatorioAcao findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relatório de Ação", id));
    }

    @Transactional
    public RelatorioAcao save(RelatorioAcao relatorio) {
        return repository.save(relatorio);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}