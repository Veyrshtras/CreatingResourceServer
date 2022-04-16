package com.example.resourceserverlesson8.service.impl;

import com.example.resourceserverlesson8.dto.QuestionVoteDto;
import com.example.resourceserverlesson8.dto.VoteType;
import com.example.resourceserverlesson8.entity.Question;
import com.example.resourceserverlesson8.entity.QuestionVote;
import com.example.resourceserverlesson8.entity.User;
import com.example.resourceserverlesson8.repository.QuestionVoteRepository;
import com.example.resourceserverlesson8.repository.UserRepository;
import com.example.resourceserverlesson8.service.QuestionVoteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class QuestionVoteServiceImpl implements QuestionVoteService {

    private final QuestionVoteRepository repository;
    private final UserRepository userRepository;

    private final EntityManager entityManager;

    public QuestionVoteServiceImpl(QuestionVoteRepository repository, UserRepository userRepository, EntityManager entityManager) {
        this.repository = repository;
        this.userRepository = userRepository;

        this.entityManager = entityManager;
    }


    @Override
    public QuestionVoteDto upVote(Long questionId, String username) {
        Optional<User> optionalUser=userRepository.findByEmail(username);
        if (optionalUser.isPresent()){
            Optional<QuestionVote> questionVote=repository.
                    findByQuestion_IdAndCreatedByAndDeletedFalse(questionId, optionalUser.get());
            if (!questionVote.isPresent()){
                QuestionVote vote= new QuestionVote();
                vote.setQuestion(entityManager.getReference(Question.class, questionId));
                vote.setType(VoteType.UP);
                QuestionVoteDto dto=QuestionVoteDto.fromQuestionVote(repository.save(vote));
                reCalculateQuestionVote(dto.getQuestionId());
                return dto;
            }
        }
        return null;
    }

    @Override
    public QuestionVoteDto downVote(Long questionId, String username) {
        Optional<User> optionalUser=userRepository.findByEmail(username);
        if (optionalUser.isPresent()){
            Optional<QuestionVote> questionVote=repository.
                    findByQuestion_IdAndCreatedByAndDeletedFalse(questionId, optionalUser.get());
            if (!questionVote.isPresent()){
                QuestionVote vote= new QuestionVote();
                vote.setQuestion(entityManager.getReference(Question.class, questionId));
                vote.setType(VoteType.DOWN);
                QuestionVoteDto dto=QuestionVoteDto.fromQuestionVote(repository.save(vote));
                reCalculateQuestionVote(dto.getQuestionId());
                return dto;
            }
        }
        return null;
    }

    @Override
    public QuestionVoteDto revertVote(Long questionId, String username) {
        Optional<User> optionalUser=userRepository.findByEmail(username);
        if (optionalUser.isPresent()){
            Optional<QuestionVote> questionVote=repository.
                    findByQuestion_IdAndCreatedByAndDeletedFalse(questionId, optionalUser.get());
            if (questionVote.isPresent()){
                QuestionVoteDto dto=QuestionVoteDto.fromQuestionVote(repository.trash(questionVote.get().getId()));
                reCalculateQuestionVote(dto.getQuestionId());
                return dto;
            }
        }
        return null;
    }
    private void reCalculateQuestionVote(Long questionId){
        // TODO: 08.12.2021 calculate vote
    }
}
