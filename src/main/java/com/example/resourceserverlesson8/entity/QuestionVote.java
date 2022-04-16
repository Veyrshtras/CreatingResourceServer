package com.example.resourceserverlesson8.entity;

import com.example.resourceserverlesson8.dto.VoteType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class QuestionVote extends BaseEntity{

    @ManyToOne
    private Question question;

    @Enumerated(EnumType.STRING)
    private VoteType type;
}
