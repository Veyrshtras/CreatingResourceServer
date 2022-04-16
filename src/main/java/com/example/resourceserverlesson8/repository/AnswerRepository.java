package com.example.resourceserverlesson8.repository;

import com.example.resourceserverlesson8.entity.Answer;
import com.example.resourceserverlesson8.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends BaseRepository<Answer> {
    List<Answer> findAllByQuestion(Question question);
}
