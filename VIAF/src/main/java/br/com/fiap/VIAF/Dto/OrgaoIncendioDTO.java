package br.com.fiap.VIAF.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class OrgaoIncendioDTO {
    @NotNull(message = "ID do incêndio é obrigatório")
    private Long incendioId;

    @NotNull(message = "ID do órgão de atuação é obrigatório")
    private Long orgaoId;

    @NotNull(message = "Data de atuação é obrigatória")
    private LocalDate dataAtuacao;
}

