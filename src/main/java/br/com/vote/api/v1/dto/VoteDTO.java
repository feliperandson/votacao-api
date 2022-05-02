package br.com.vote.api.v1.dto;


import br.com.vote.api.v1.enums.DecisionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoteDTO {

    private Long id;
    private AssociateDTO associate;
    private DecisionEnum decision;
    private TopicDTO topicDTO;

}
