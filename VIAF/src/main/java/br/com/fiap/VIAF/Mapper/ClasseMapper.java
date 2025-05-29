package br.com.fiap.VIAF.Mapper;

import br.com.fiap.VIAF.DomainModel.Classe;
import br.com.fiap.VIAF.Dto.ClasseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClasseMapper {
    ClasseDTO toDTO(Classe entity);
    Classe toEntity(ClasseDTO dto);
}
