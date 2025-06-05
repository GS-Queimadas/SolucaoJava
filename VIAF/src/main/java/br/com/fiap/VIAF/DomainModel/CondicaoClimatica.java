package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "SM_CONDICOES_CLIMATICAS")
@Data @NoArgsConstructor @AllArgsConstructor
public class CondicaoClimatica {
    @Id
    @Column(name = "ID_CONDICAO")
    private Long id;

    @Column(name = "TEMPERATURA")
    private BigDecimal temperatura;

    @Column(name = "UMIDADE")
    private BigDecimal umidade;

    @Column(name = "VELOCIDADE_VENTO")
    private BigDecimal velocidadeVento;

    @Column(name = "DIRECAO_VENTO", length = 20)
    private String direcaoVento;

    @OneToOne
    @JoinColumn(name = "SM_INCENDIOS_ID_INCENDIO")
    private Incendio incendio;
}