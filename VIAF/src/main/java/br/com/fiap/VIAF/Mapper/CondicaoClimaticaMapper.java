package br.com.fiap.VIAF.Mapper;

import br.com.fiap.VIAF.DomainModel.CondicaoClimatica;
import br.com.fiap.VIAF.Dto.CondicaoClimaticaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CondicaoClimaticaMapper {

    @Mapping(source = "incendio.id", target = "incendioId")
    CondicaoClimaticaDTO toDTO(CondicaoClimatica entity);

    @Mapping(target = "incendio", ignore = true)
    CondicaoClimatica toEntity(CondicaoClimaticaDTO dto);
}
