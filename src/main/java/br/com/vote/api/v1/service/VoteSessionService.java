package br.com.vote.api.v1.service;

import br.com.vote.api.v1.domain.VoteSession;
import br.com.vote.api.v1.dto.VoteSessionDTO;
import br.com.vote.api.v1.mapper.VoteSessionMapper;
import br.com.vote.api.v1.repository.VoteSessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteSessionService {

    private final Logger log = LoggerFactory.getLogger(VoteSessionService.class);

    @Autowired
    private VoteSessionRepository repository;

    @Autowired
    private VoteSessionMapper mapper;

    @Transactional
    public VoteSessionDTO save(VoteSessionDTO dto) {
        log.debug("Request to save Voting Session: {}", dto);

        VoteSession VoteSession = mapper.toEntity(dto);
        VoteSession = repository.save(VoteSession);

        return mapper.toDto(VoteSession);

    }

}
