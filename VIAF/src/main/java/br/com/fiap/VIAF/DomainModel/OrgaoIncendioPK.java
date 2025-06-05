package br.com.fiap.VIAF.DomainModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgaoIncendioPK implements Serializable {
    private Long incendioId;
    private Long orgaoId;
}
