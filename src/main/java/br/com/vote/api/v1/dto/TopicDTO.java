package br.com.vote.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TopicDTO {

    private Long id;
    private String description;
    private LocalDateTime createdDate;
    @JsonIgnore(value = true)
    private VoteSessionDTO VoteSessionDTO;

}
