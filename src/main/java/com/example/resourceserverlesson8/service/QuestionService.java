package com.example.resourceserverlesson8.service;

import com.example.resourceserverlesson8.dto.QuestionDto;
import com.example.resourceserverlesson8.dto.QuestionForm;
import com.example.resourceserverlesson8.dto.QuestionListItemDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface QuestionService {

    Page<QuestionListItemDto> findAllByCategory(Long categoryId, Pageable pageable);

    QuestionDto findOne(Long id);

    QuestionListItemDto add(QuestionForm form);

    QuestionListItemDto update(Long id, QuestionForm form);

    QuestionListItemDto delete(Long id);
}
