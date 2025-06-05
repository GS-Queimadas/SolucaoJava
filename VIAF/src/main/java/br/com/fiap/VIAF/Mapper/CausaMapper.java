package br.com.fiap.VIAF.Mapper;

import br.com.fiap.VIAF.DomainModel.Causa;
import br.com.fiap.VIAF.Dto.CausaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CausaMapper {
    CausaDTO toDTO(Causa entity);
    Causa toEntity(CausaDTO dto);
}
