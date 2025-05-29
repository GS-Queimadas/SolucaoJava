package br.com.fiap.VIAF.Dto;

import lombok.Data;

@Data
public class CondicaoClimaticaDTO {
    private Long id;
    private Double temperatura;
    private Double umidade;
    private Double velocidadeVento;
    private String direcaoVento;
    private Long incendioId;
}