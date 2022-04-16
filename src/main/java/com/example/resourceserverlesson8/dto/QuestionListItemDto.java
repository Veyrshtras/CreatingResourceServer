package com.example.resourceserverlesson8.dto;

import com.example.resourceserverlesson8.entity.Question;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class QuestionListItemDto {

    private Long id;

    private String title;

    private String description;

    private Set<TagDto> tags;

    private Long view;

    private Long time;

    private Long vote;

    private UserDto author;

}
