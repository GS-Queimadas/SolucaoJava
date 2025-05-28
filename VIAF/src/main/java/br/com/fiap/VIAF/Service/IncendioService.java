package br.com.fiap.VIAF.Service;

import br.com.fiap.VIAF.DomainModel.Incendio;
import br.com.fiap.VIAF.Repository.IncendioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncendioService {
    private final IncendioRepository repository;

    public IncendioService(IncendioRepository repository) {
        this.repository = repository;
    }
    public List<Incendio> listarTodos(){
        return repository.findAll();
    }

    public Incendio buscarPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Incendio não encontrado com Id: " + id));
    }

    public Incendio salvar(Incendio incendio){
        return repository.save(incendio);
    }

    public Incendio atualizar(Long id, Incendio dadosAtualizados){
        Incendio existente = buscarPorId(id);
        existente.setNmIncendio(dadosAtualizados.getNmIncendio());
        existente.setAnoIncendio(dadosAtualizados.getAnoIncendio());
        existente.setDtDescoberta(dadosAtualizados.getDtDescoberta());
        existente.setDtControle(dadosAtualizados.getDtControle());
        existente.setAreaAfetada(dadosAtualizados.getAreaAfetada());
        existente.setCausa(dadosAtualizados.getCausa());
        existente.setClasse(dadosAtualizados.getClasse());
        existente.setLocalizacao(dadosAtualizados.getLocalizacao());
        return repository.save(existente);
    }

    public void deletar(Long id){
        Incendio incendio = buscarPorId(id);
        repository.delete(incendio);

    }

    public List<Incendio> buscarPorAno(Integer ano){
        return repository.findByAnoIncendio(ano);
    }
    public List<Incendio> buscarPorEstado(String estado){
        return repository.findByLocalizacaoEstadoIgnoreCase(estado);
    }
    public List<Incendio> buscarPorCausa(Long idCausa){
        return repository.findByCausaIdCausa(idCausa);
    }
}
