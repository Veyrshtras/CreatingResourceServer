package com.example.resourceserverlesson8.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Question extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category category;

    private String title;

    @Column(columnDefinition = "text")
    private String description;

    private Long viewCount;

    private Long voteCount;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags;

}
