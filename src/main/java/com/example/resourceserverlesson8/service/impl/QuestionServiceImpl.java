package com.example.resourceserverlesson8.service.impl;

import com.example.resourceserverlesson8.dto.QuestionDto;
import com.example.resourceserverlesson8.dto.QuestionForm;
import com.example.resourceserverlesson8.dto.QuestionListItemDto;
import com.example.resourceserverlesson8.entity.Answer;
import com.example.resourceserverlesson8.entity.Question;
import com.example.resourceserverlesson8.repository.AnswerRepository;
import com.example.resourceserverlesson8.repository.QuestionRepository;
import com.example.resourceserverlesson8.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    private final AnswerRepository answerRepository;

    public QuestionServiceImpl(QuestionRepository repository, AnswerRepository answerRepository) {
        this.repository = repository;
        this.answerRepository = answerRepository;
    }


    @Override
    public Page<QuestionListItemDto> findAllByCategory(Long categoryId, Pageable pageable) {
        return repository.findAllByCategory_Id(categoryId,pageable)
                .map(question -> new QuestionDto.Builder(question).built());
    }

    @Override
    public QuestionDto findOne(Long id) {
        Question question=repository.getOne(id);
        List<Answer> answers=answerRepository.findAllByQuestion(question);
        return new QuestionDto.Builder(question).answers(answers).built();
    }

    @Override
    public QuestionListItemDto add(QuestionForm form) {
        // TODO: 08.12.2021 need to implement to add method
        return null;
    }

    @Override
    public QuestionListItemDto update(Long id, QuestionForm form) {
        // TODO: 08.12.2021 need to implement to update method
        return null;
    }

    @Override
    public QuestionListItemDto delete(Long id) {
        return new QuestionDto.Builder(repository.trash(id)).built();
    }
}
