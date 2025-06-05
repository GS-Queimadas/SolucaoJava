package br.com.fiap.VIAF.service;

import br.com.fiap.VIAF.DomainModel.Incendio;
import br.com.fiap.VIAF.Exception.BadRequestException;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Repository.IncendioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class IncendioService {

    private final IncendioRepository repository;

    public IncendioService(IncendioRepository repository) {
        this.repository = repository;
    }

    public List<Incendio> findAll() {
        return repository.findAll();
    }

    public Incendio findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incêndio", id));
    }

    @Transactional
    public Incendio save(Incendio incendio) {
        if (incendio.getDataControle() != null
                && incendio.getDataControle().isBefore(incendio.getDataDescoberta())) {
            throw new BadRequestException("Data de controle não pode ser anterior à data de descoberta");
        }
        return repository.save(incendio);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}