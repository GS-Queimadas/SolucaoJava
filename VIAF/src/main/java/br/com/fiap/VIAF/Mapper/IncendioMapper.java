package br.com.fiap.VIAF.Mapper;

import br.com.fiap.VIAF.DomainModel.Causa;
import br.com.fiap.VIAF.DomainModel.Classe;
import br.com.fiap.VIAF.DomainModel.Incendio;
import br.com.fiap.VIAF.DomainModel.Localizacao;
import br.com.fiap.VIAF.Dto.IncendioRequestDto;
import br.com.fiap.VIAF.Dto.IncendioResponseDto;


public class IncendioMapper {
    public static Incendio toEntity(IncendioRequestDto dto, Causa causa, Classe classe, Localizacao localizacao) {
        Incendio incendio = new Incendio();
        incendio.setNmIncendio(dto.getNmIncendio());
        incendio.setAnoIncendio(dto.getAnoIncendio());
        incendio.setCausa(causa);
        incendio.setClasse(classe);
        incendio.setLocalizacao(localizacao);
        return incendio;
    }

    public static IncendioResponseDto toDTO(Incendio incendio) {
        IncendioResponseDto dto = new IncendioResponseDto();
        dto.setId(incendio.getIdIncendio());
        dto.setNmIncendio(incendio.getNmIncendio());
        dto.setAnoIncendio(incendio.getAnoIncendio());
        dto.setCausaId(incendio.getCausa().getIdCausa());
        dto.setClasseId(Long.valueOf(incendio.getClasse().getIdClasse()));
        dto.setLocalizacaoId(incendio.getLocalizacao().getIdLocalizacao());
        return dto;
    }
}

