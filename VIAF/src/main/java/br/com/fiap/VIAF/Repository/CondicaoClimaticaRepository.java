package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.CondicaoClimatica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicaoClimaticaRepository extends JpaRepository<CondicaoClimatica, Long> {
}