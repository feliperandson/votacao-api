package br.com.vote.api.v1.service;

import br.com.vote.api.v1.domain.Associate;
import br.com.vote.api.v1.dto.AssociateDTO;
import br.com.vote.api.v1.mapper.AssociateMapper;
import br.com.vote.api.v1.repository.AssociateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssociateService  {

    private final Logger log = LoggerFactory.getLogger(AssociateService.class);

    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private AssociateMapper associateMapper;

    @Transactional
    public AssociateDTO save(AssociateDTO dto) {
        log.debug("Request to save Associate: {}", dto);

        Associate associate = associateMapper.toEntity(dto);
        associate = associateRepository.save(associate);

        return associateMapper.toDto(associate);
    }

    public List<AssociateDTO> list() {
        List<Associate> list = associateRepository.findAll();
        return associateMapper.toDto(list);
    }
}
