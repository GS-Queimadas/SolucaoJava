package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "SM_CAUSAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Causa {
    @Id
    @Column(name = "ID_CAUSA")
    private Long id;

    @Column(name = "CLASSIFICACAO_CAUSA", length = 100)
    private String classificacaoCausa;

    @Column(name = "CAUSA_GERAL", length = 200)
    private String causaGeral;

    @OneToMany(mappedBy = "causa", cascade = CascadeType.ALL)
    private List<Incendio> incendios;
}