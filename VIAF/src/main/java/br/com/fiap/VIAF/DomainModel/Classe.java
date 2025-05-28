package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SM_CLASSES")
public class Classe {
    @Id
    private String idClasse;
    private String descricao;
}
