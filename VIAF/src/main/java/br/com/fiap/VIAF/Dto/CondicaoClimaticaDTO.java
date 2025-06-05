package br.com.fiap.VIAF.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CondicaoClimaticaDTO {
    private Long id;

    @NotNull(message = "Temperatura é obrigatória")
    @DecimalMin(value = "-50.0", message = "Temperatura mínima é -50")
    @DecimalMax(value = "60.0", message = "Temperatura máxima é 60")
    private Double temperatura;

    @NotNull(message = "Umidade é obrigatória")
    @Min(value = 0, message = "Umidade mínima é 0")
    @Max(value = 100, message = "Umidade máxima é 100")
    private Double umidade;

    @DecimalMin(value = "0.0", message = "Velocidade do vento deve ser >= 0")
    private Double velocidadeVento;

    @Size(max = 20, message = "Direção do vento deve ter até 20 caracteres")
    private String direcaoVento;

    @NotNull(message = "ID do incêndio é obrigatório")
    private Long incendioId;
}