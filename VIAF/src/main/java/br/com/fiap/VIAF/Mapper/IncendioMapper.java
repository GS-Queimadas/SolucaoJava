package br.com.fiap.VIAF.Mapper;

import br.com.fiap.VIAF.DomainModel.Incendio;
import br.com.fiap.VIAF.Dto.IncendioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface IncendioMapper {

    @Mapping(source = "causa.id",   target = "causaId")
    @Mapping(source = "classe.id", target = "classeId")
    IncendioDTO toDTO(Incendio entity);

    @Mapping(target = "causa", ignore = true)
    @Mapping(target = "classe", ignore = true)
    Incendio toEntity(IncendioDTO dto);
}