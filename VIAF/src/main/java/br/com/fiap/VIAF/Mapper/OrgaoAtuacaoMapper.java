package br.com.fiap.VIAF.Mapper;

import br.com.fiap.VIAF.DomainModel.OrgaoAtuacao;
import br.com.fiap.VIAF.Dto.OrgaoAtuacaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrgaoAtuacaoMapper {
    OrgaoAtuacaoDTO toDTO(OrgaoAtuacao entity);
    OrgaoAtuacao toEntity(OrgaoAtuacaoDTO dto);
}