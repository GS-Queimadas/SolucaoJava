package br.com.fiap.VIAF.Mapper;

import br.com.fiap.VIAF.DomainModel.RelatorioAcao;
import br.com.fiap.VIAF.Dto.RelatorioAcaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface RelatorioAcaoMapper {
    @Mapping(source = "incendio.id", target = "incendioId")
    RelatorioAcaoDTO toDTO(RelatorioAcao entity);

    @Mapping(target = "incendio", ignore = true) // se você só ligar por ID
    RelatorioAcao toEntity(RelatorioAcaoDTO dto);
}
