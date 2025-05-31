package br.com.fiap.VIAF.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class RelatorioAcaoDTO {
    private Long id;

    @NotNull(message = "Data do relatório é obrigatória")
    private LocalDate dataRelatorio;

    @NotBlank(message = "Resumo operacional é obrigatório")
    private String resumoOperacional;

    private String dificuldades;
    private String recomendacoes;

    @NotNull(message = "ID do incêndio é obrigatório")
    private Long incendioId;
}