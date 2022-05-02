package br.com.vote.api.v1.mapper;


import br.com.vote.api.v1.domain.Vote;
import br.com.vote.api.v1.dto.VoteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { VoteMapper.class })
public interface VoteMapper extends EntityMapper<VoteDTO, Vote>{

    VoteDTO toDto(Vote a);

    Vote toEntity(VoteDTO dto);

}
