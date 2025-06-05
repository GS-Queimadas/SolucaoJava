package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "SM_INCENDIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incendio {
    @Id
    @Column(name = "ID_INCENDIO")
    private Long id;

    @Column(name = "NOME_INCENDIO", length = 100)
    private String nome;

    @Column(name = "DT_DESCOBERTA")
    private LocalDate dataDescoberta;

    @Column(name = "DT_CONTROLE")
    private LocalDate dataControle;

    @Column(name = "AREA_AFETADA_ACRES", precision = 10, scale = 2)
    private BigDecimal areaAfetada;

    @Column(name = "LATITUDE", precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(name = "LONGITUDE", precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "ESTADO", length = 2)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "SM_CAUSAS_ID_CAUSA")
    private Causa causa;

    @ManyToOne
    @JoinColumn(name = "SM_CLASSES_ID_CLASSE")
    private Classe classe;

    @OneToOne(mappedBy = "incendio", cascade = CascadeType.ALL)
    private CondicaoClimatica condicao;

    @OneToMany(mappedBy = "incendio", cascade = CascadeType.ALL)
    private List<RelatorioAcao> acoes;

    @OneToMany(mappedBy = "incendio", cascade = CascadeType.ALL)
    private List<OrgaoIncendio> orgaosIncendio;
}