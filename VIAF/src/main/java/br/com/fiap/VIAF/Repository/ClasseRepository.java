package br.com.fiap.VIAF.Repository;

import br.com.fiap.VIAF.DomainModel.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe,String> {
}
