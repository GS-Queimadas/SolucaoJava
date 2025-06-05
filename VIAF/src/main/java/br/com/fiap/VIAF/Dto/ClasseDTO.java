package br.com.fiap.VIAF.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClasseDTO {
    @NotBlank(message = "ID da classe é obrigatório")
    @Size(min = 1, max = 2, message = "ID da classe deve ter 1 ou 2 caracteres")
    private String id;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 200, message = "Descrição deve ter até 200 caracteres")
    private String descricao;
}


