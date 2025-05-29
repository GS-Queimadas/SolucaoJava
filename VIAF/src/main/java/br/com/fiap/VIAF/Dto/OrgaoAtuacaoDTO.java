package br.com.fiap.VIAF.Dto;

import lombok.Data;

@Data
public class OrgaoAtuacaoDTO {
    private Long id;
    private String municipio;
    private String tipo;
    private String telefone;
    private String cep;
    private String rua;
    private Integer numero;
    private String complemento;
}