package br.com.fiap.VIAF.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncendioResponseDto {
    private Long id;
    private String nmIncendio;
    private Integer anoIncendio;
    private LocalDate dtDescoberta;
    private LocalDate dtControle;
    private Double areaAfetada;
    private Long causaId;
    private String causaDescricao;
    private Long classeId;
    private String classeDescricao;
    private Long localizacaoId;
    private String estado;
    private Double latitude;
    private Double longitude;


}
