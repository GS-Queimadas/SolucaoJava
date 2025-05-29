package br.com.fiap.VIAF.Dto;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class OrgaoIncendioDTO implements Serializable {
    private Long incendioId;
    private Long orgaoId;
    private LocalDate dataAtuacao;
}

