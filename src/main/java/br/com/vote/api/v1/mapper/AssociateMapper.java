package br.com.vote.api.v1.mapper;

import br.com.vote.api.v1.domain.Associate;
import br.com.vote.api.v1.dto.AssociateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { AssociateMapper.class })
public interface AssociateMapper extends EntityMapper<AssociateDTO, Associate> {

    AssociateDTO toDto(Associate a);

    Associate toEntity(AssociateDTO dto);



}

