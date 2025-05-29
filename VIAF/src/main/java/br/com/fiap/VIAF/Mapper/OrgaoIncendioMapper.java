package br.com.fiap.VIAF.Mapper;

import br.com.fiap.VIAF.DomainModel.OrgaoIncendio;
import br.com.fiap.VIAF.Dto.OrgaoIncendioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface OrgaoIncendioMapper {

    OrgaoIncendioDTO toDTO(OrgaoIncendio entity);

    @Mapping(target = "incendio",     ignore = true)
    @Mapping(target = "orgaoAtuacao", ignore = true)
    OrgaoIncendio toEntity(OrgaoIncendioDTO dto);
}
