package br.com.vote.api.v1.controller;

import br.com.vote.api.v1.dto.AssociateDTO;
import br.com.vote.api.v1.service.AssociateService;
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


@Tag(name = "Associado")
@RestController
@RequestMapping(value = "/api/v1/associate")
public class AssociateController {
    @Autowired
    private AssociateService service;

    @Operation(description = "Lista todos os associados")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssociateDTO>> list() {
        List<AssociateDTO> associateDTOS = service.list();

        return new ResponseEntity<>(associateDTOS, HttpStatus.OK);
    }
    @Operation(description = "Cadastra um novo associador")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AssociateDTO> save(@Valid @RequestBody AssociateDTO associate){
        AssociateDTO associateDTO = service.save(associate);

        return new ResponseEntity<>(associateDTO, HttpStatus.OK);
    }

}
