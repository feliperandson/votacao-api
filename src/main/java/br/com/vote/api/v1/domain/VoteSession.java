package br.com.vote.api.v1.domain;

import br.com.vote.api.v1.enums.SessionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "vote_session")
public class VoteSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    @NotBlank(message = "Id do tópico é obrigatório")
    private Topic topic;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "session_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private SessionStatusEnum sessionStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vote_session__vote",
            joinColumns = @JoinColumn(name = "session_voting_id"),
            inverseJoinColumns = @JoinColumn(name = "voto_id")
    )
    private List<Vote> votes;



}
