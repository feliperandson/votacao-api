package br.com.vote.api.v1.mapper;

import br.com.vote.api.v1.domain.Topic;
import br.com.vote.api.v1.dto.TopicDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { TopicMapper.class })
public interface TopicMapper extends EntityMapper<TopicDTO, Topic> {

    TopicDTO toDto(Topic a);

    Topic toEntity(TopicDTO dto);
}
