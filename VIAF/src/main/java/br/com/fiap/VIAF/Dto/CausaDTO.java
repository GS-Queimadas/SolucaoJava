package br.com.fiap.VIAF.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CausaDTO {
    private Long id;

    @NotBlank(message = "Classificação é obrigatória")
    @Size(max = 100, message = "Classificação deve ter até 100 caracteres")
    private String classificacao;

    @NotBlank(message = "Campo 'geral' é obrigatório")
    @Size(max = 200, message = "‘Geral’ deve ter até 200 caracteres")
    private String geral;
}