package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.Incendio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncendioRepository extends JpaRepository <Incendio,Long> {


}
