package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "SM_ACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioAcao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RELATORIO")
    private Long id;

    @Column(name = "DT_RELATORIO")
    private LocalDate dataRelatorio;

    @Lob
    @Column(name = "RESUMO_OPERACIONAL")
    private String resumoOperacional;

    @Lob
    @Column(name = "DIFICULDADES")
    private String dificuldades;

    @Lob
    @Column(name = "RECOMENDACOES")
    private String recomendacoes;

    @ManyToOne
    @JoinColumn(name = "SM_INCENDIOS_ID_INCENDIO")
    private Incendio incendio;
}
