package br.com.fiap.VIAF.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class IncendioDTO {
    private Long id;

    @NotBlank(message = "Nome do incêndio é obrigatório")
    @Size(max = 100, message = "Nome deve ter até 100 caracteres")
    private String nome;

    @NotNull(message = "Data de descoberta é obrigatória")
    private LocalDate dataDescoberta;

    private LocalDate dataControle;

    @PositiveOrZero(message = "Área afetada deve ser zero ou positiva")
    private Double areaAfetada;

    @DecimalMin(value = "-90.0", message = "Latitude mínima é -90")
    @DecimalMax(value = "90.0", message = "Latitude máxima é 90")
    private Double latitude;

    @DecimalMin(value = "-180.0", message = "Longitude mínima é -180")
    @DecimalMax(value = "180.0", message = "Longitude máxima é 180")
    private Double longitude;

    @NotBlank(message = "Estado é obrigatório")
    @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres (sigla)")
    private String estado;

    @NotNull(message = "ID da causa é obrigatório")
    private Long causaId;

    @NotBlank(message = "ID da classe é obrigatório")
    private String classeId;
}
