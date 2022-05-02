package br.com.vote.api.v1.service;

import br.com.vote.api.v1.domain.Topic;
import br.com.vote.api.v1.dto.TopicDTO;
import br.com.vote.api.v1.mapper.TopicMapper;
import br.com.vote.api.v1.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService {

    private final Logger log = LoggerFactory.getLogger(TopicService.class);

    @Autowired
    private TopicRepository repository;

    @Autowired
    private TopicMapper mapper;

    @Transactional
    public TopicDTO save(TopicDTO dto) {
        log.debug("Request to save Topic: {}", dto);

        Topic topic = mapper.toEntity(dto);
        topic = repository.save(topic);

        return mapper.toDto(topic);

    }


    public List<TopicDTO> list() {
        List<Topic> list = repository.findAll();
        return mapper.toDto(list);
    }
}
