package com.example.resourceserverlesson8.service;


import com.example.resourceserverlesson8.dto.CategoryDto;
import com.example.resourceserverlesson8.entity.Category;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll(@Nullable Long parentId);

    CategoryDto getOne(Long id);

    CategoryDto add(CategoryDto categoryDto);

    CategoryDto update(Long id, CategoryDto categoryDto);

    CategoryDto delete(Long id);

}
