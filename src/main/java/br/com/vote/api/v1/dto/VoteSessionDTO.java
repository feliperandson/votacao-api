package br.com.vote.api.v1.dto;

import br.com.vote.api.v1.enums.SessionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoteSessionDTO {

    private Long id;
    private TopicDTO topicDTO;
    private Integer duration;
    private LocalDateTime createdDate;
    private SessionStatusEnum sessionStatus;
    private List<VoteDTO> votes;

}
