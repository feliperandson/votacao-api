package br.com.vote.api.v1.mapper;

import br.com.vote.api.v1.domain.VoteSession;
import br.com.vote.api.v1.dto.VoteSessionDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = { VoteSessionMapper.class })
public interface VoteSessionMapper extends EntityMapper<VoteSessionDTO, VoteSession> {

    VoteSessionDTO toDto(VoteSession a);

    VoteSession toEntity(VoteSessionDTO dto);

}
