package com.example.resourceserverlesson8.dto;

import com.example.resourceserverlesson8.entity.Answer;
import com.example.resourceserverlesson8.entity.Question;
import com.example.resourceserverlesson8.entity.QuestionVote;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class QuestionDto extends QuestionListItemDto {

    private QuestionVoteDto vote;

    // TODO: 08.12.2021 there are must be set of answer items

    public static class Builder{

        private Question question;
        private List<Answer> answers;
        private QuestionVote vote;

        public Builder(Question question) {
            this.question = question;
        }

        public Builder answers(List<Answer> answers){
            this.answers=answers;
            return this;
        }

        public Builder vote(QuestionVote vote){
            this.vote=vote;
            return this;
        }

        public QuestionDto built(){

            QuestionDto dto=new QuestionDto();

            dto.setId(question.getId());
            dto.setTitle(question.getTitle());
            dto.setDescription(question.getDescription());
            dto.setTags(question.getTags().stream().map(TagDto::fromTag).collect(Collectors.toSet()));
            if (question.getCreatedBy()!=null)
                dto.setAuthor(UserDto.fromUser(question.getCreatedBy()));
            dto.setView(question.getViewCount());
            dto.setTime(question.getCreatedDate().getTime());
            if(this.vote!=null){
                // TODO: 08.12.2021 set vote
            }
            if(this.answers!=null){
                // TODO: 08.12.2021 set answers
            }

            return null;
        }
    }

}
