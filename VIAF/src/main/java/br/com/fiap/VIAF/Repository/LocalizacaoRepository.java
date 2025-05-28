package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao,Long> {
}
