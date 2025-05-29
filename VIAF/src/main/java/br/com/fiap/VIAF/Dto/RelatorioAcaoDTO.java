package br.com.fiap.VIAF.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RelatorioAcaoDTO {
    private Long id;
    private LocalDate dataRelatorio;
    private String resumoOperacional;
    private String dificuldades;
    private String recomendacoes;
    private Long incendioId;
}