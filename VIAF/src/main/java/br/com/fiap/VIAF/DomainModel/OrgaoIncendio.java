package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "SM_ORGAO_INCENDIO")
@IdClass(OrgaoIncendioPK.class)
@Data @NoArgsConstructor @AllArgsConstructor
public class OrgaoIncendio implements Serializable {

    @Id
    @Column(name = "SM_INCENDIOS_ID_INCENDIO")
    private Long incendioId;

    @Id
    @Column(name = "SM_ORGAO_ATUACAO_COD_ORGAO")
    private Long orgaoId;

    @Column(name = "DT_ATUACAO")
    private LocalDate dataAtuacao;

    @ManyToOne
    @JoinColumn(name = "SM_INCENDIOS_ID_INCENDIO", insertable = false, updatable = false)
    private Incendio incendio;

    @ManyToOne
    @JoinColumn(name = "SM_ORGAO_ATUACAO_COD_ORGAO", insertable = false, updatable = false)
    private OrgaoAtuacao orgaoAtuacao;
}