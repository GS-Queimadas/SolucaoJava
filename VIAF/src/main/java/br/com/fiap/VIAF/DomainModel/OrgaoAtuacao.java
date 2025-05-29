package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "SM_ORGAO_ATUACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgaoAtuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ORGAO")
    private Long id;

    @Column(name = "MUNICIPIO")
    private String municipio;

    @Column(name = "TP_ORGAO")
    private String tipoOrgao;

    @Column(name = "TEL")
    private String telefone;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "RUA")
    private String rua;

    @Column(name = "NR")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @OneToMany(mappedBy = "orgaoAtuacao", cascade = CascadeType.ALL)
    private List<OrgaoIncendio> orgaosIncendio;
}