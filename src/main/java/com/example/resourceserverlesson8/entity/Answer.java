package com.example.resourceserverlesson8.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter

public class Answer extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Question question;

    @Column(columnDefinition = "text")
    private String content;

    @Column(nullable = false)
    private Long viewCount=0L;

}
