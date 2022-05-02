package br.com.vote.api.v1.controller;

import br.com.vote.api.v1.dto.TopicDTO;
import br.com.vote.api.v1.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Pauta")
@RestController
@RequestMapping(value = "/api/v1/topic")
public class TopicController {

    @Autowired
    private TopicService service;

    @Operation(description = "Lista as pautas criadas")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TopicDTO>> list() {
        List<TopicDTO> topicDtos = service.list();

        return new ResponseEntity<>(topicDtos, HttpStatus.OK);
    }
    @Operation(description = "Cadastra uma nova pauta")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TopicDTO> save(@Valid @RequestBody TopicDTO topic){
        TopicDTO topicDTO = service.save(topic);

        return new ResponseEntity<>(topicDTO, HttpStatus.OK);
    }

}
