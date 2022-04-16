package com.example.resourceserverlesson8.dto;

import com.example.resourceserverlesson8.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CategoryDto {

    private Long id;

    private String title;

    private String description;

    private Long parent;

    private String icon;

    public static CategoryDto fromCategory(Category category){

        CategoryDto dto= new CategoryDto();
        dto.setId(category.getId());
        dto.setTitle(category.getTitle());
        dto.setDescription(category.getDescription());
        dto.setIcon(category.getIconCode());
        if (category.getParent()!=null)
            dto.setParent(category.getParent().getId());

        return dto;
    }

}
