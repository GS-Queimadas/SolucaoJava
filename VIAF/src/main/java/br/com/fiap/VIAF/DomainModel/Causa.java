package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SM_CAUSAS")
public class Causa {
    @Id
    private Long idCausa;
    private String classificacaoCausa;
    private String causaGeral;

}
