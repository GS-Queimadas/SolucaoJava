package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.RelatorioAcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioAcaoRepository extends JpaRepository<RelatorioAcao, Long> {
}
