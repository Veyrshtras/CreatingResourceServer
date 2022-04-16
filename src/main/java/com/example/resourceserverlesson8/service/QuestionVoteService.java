package com.example.resourceserverlesson8.service;

import com.example.resourceserverlesson8.dto.QuestionVoteDto;
import com.example.resourceserverlesson8.entity.QuestionVote;

public interface QuestionVoteService {

    QuestionVoteDto upVote(Long questionId, String username);

    QuestionVoteDto downVote(Long questionId, String username);

    QuestionVoteDto revertVote(Long questionId, String username);
}
