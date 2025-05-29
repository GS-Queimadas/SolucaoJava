package br.com.fiap.VIAF.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncendioDTO {
    private Long id;
    private String nome;
    private LocalDate dataDescoberta;
    private LocalDate dataControle;
    private Double areaAfetada;
    private Double latitude;
    private Double longitude;
    private String estado;
    private Long causaId;
    private String classeId;
}
