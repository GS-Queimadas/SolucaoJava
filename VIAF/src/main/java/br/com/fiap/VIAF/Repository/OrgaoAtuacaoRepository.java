package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.OrgaoAtuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoAtuacaoRepository extends JpaRepository<OrgaoAtuacao, Long> {
}