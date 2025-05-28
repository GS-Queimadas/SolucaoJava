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
public class IncendioRequestDto {
    private String nmIncendio;
    private Integer anoIncendio;
    private LocalDate dtDescoberta;
    private Integer diaDescoberta;
    private LocalDate dtControle;
    private Integer diaControle;
    private Double areaAfetada;

    private Long causaId;
    private Long classeId;
    private Long localizacaoId;

}