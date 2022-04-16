package com.example.resourceserverlesson8.dto;

import com.example.resourceserverlesson8.entity.QuestionVote;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionVoteDto {
    private Long id;

    private Long questionId;

    private VoteType type;

    public static QuestionVoteDto fromQuestionVote(QuestionVote questionVote){
        QuestionVoteDto dto=new QuestionVoteDto();
        dto.setId(questionVote.getId());
        dto.setType(questionVote.getType());
        dto.setQuestionId(questionVote.getQuestion().getId());
        return dto;
    }
}
