package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "SM_INCENDIOS")
public class Incendio {
    @Id
    private Long idIncendio;
    private String nmIncendio;
    private Integer anoIncendio;
    private LocalDate dtDescoberta;
    private LocalDate dtControle;
    private BigDecimal areaAfetada;

    @ManyToOne
    @JoinColumn(name = "SM_CAUSAS_ID_CAUSA")
    private Causa causa;


    @ManyToOne
    @JoinColumn(name = "SM_CLASSES_ID_CLASSE")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "SM_LOCALIZACAO_ID_LOCALIZACAO")
    private Localizacao localizacao;
}
