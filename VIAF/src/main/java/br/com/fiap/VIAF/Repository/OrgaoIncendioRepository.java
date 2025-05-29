package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.OrgaoIncendio;
import br.com.fiap.VIAF.DomainModel.OrgaoIncendioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoIncendioRepository extends JpaRepository<OrgaoIncendio, OrgaoIncendioPK> {
}