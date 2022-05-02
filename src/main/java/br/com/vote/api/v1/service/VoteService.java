package br.com.vote.api.v1.service;

import br.com.vote.api.v1.domain.Vote;
import br.com.vote.api.v1.dto.VoteDTO;
import br.com.vote.api.v1.repository.VoteRepository;
import br.com.vote.api.v1.mapper.VoteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteService {

    private final Logger log = LoggerFactory.getLogger(VoteService.class);

    @Autowired
    private VoteRepository repository;

    @Autowired
    private VoteMapper mapper;

    @Transactional
    public VoteDTO save(VoteDTO dto) {
        log.debug("Request to save Vote: {}", dto);

        Vote vote = mapper.toEntity(dto);
        vote = repository.save(vote);

        return mapper.toDto(vote);

    }

}
