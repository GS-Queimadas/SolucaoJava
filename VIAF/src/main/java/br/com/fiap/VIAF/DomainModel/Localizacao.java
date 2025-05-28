package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name = "SM_LOCALIZACAO")
public class Localizacao {
    @Id
    private Long idLocalizacao;
    private BigDecimal latitude;
    private BigDecimal logitude;
    private String estado;
}
