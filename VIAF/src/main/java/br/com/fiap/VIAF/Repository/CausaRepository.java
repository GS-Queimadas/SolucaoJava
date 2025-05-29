package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.Causa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CausaRepository extends JpaRepository <Causa,Long>  {

}
