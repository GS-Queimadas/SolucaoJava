package br.com.fiap.VIAF.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrgaoAtuacaoDTO {
    private Long id;

    @NotBlank(message = "Município é obrigatório")
    @Size(max = 100, message = "Município deve ter até 100 caracteres")
    private String municipio;

    @NotBlank(message = "Tipo de órgão é obrigatório")
    @Size(max = 100, message = "Tipo de órgão deve ter até 100 caracteres")
    private String tipo;

    @Size(max = 15, message = "Telefone deve ter até 15 caracteres")
    private String telefone;

    @Size(max = 9, message = "CEP deve ter até 9 caracteres")
    private String cep;

    @Size(max = 100, message = "Rua deve ter até 100 caracteres")
    private String rua;

    private Integer numero;

    @Size(max = 100, message = "Complemento deve ter até 100 caracteres")
    private String complemento;
}