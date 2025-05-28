package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.Incendio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncendioRepository extends JpaRepository <Incendio,Long> {
    List<Incendio> findByAnoIncendio(Integer ano);
    List<Incendio> findByLocalizacaoEstadoIgnoreCase(String estado);
    List<Incendio> findByCausaIdCausa(Long idCausa);

}
