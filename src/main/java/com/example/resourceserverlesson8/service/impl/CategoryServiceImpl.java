package com.example.resourceserverlesson8.service.impl;

import com.example.resourceserverlesson8.dto.CategoryDto;
import com.example.resourceserverlesson8.entity.Category;
import com.example.resourceserverlesson8.repository.CategoryRepository;
import com.example.resourceserverlesson8.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final EntityManager entityManager;
    public CategoryServiceImpl(CategoryRepository categoryRepository, EntityManager entityManager) {
        this.categoryRepository = categoryRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<CategoryDto> findAll(Long parentId) {
        return categoryRepository.findAllByParent_IdAndDeletedFalse(parentId)
                .stream()
                .map(CategoryDto::fromCategory)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getOne(Long id) {
        return CategoryDto.fromCategory(categoryRepository.getOne(id));
    }

    @Override
    public CategoryDto add(CategoryDto categoryDto) {

        return CategoryDto.fromCategory(fillCategory(new Category(), categoryDto));
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        return CategoryDto.fromCategory(fillCategory(categoryRepository.getById(id), categoryDto));
    }

    @Override
    public CategoryDto delete(Long id) {

        return CategoryDto.fromCategory(categoryRepository.trash(id));
    }

    private Category  fillCategory(Category category, CategoryDto categoryDto){
        category.setDescription(categoryDto.getDescription());
        category.setTitle(categoryDto.getTitle());
        category.setIconCode(categoryDto.getIcon());
        if (categoryDto.getParent()!=null) {
            category.setParent(entityManager.getReference(Category.class, categoryDto.getId())); /// second way
//            category.setParent(categoryRepository.getById(categoryDto.getParent())); // first way
        }
        return categoryRepository.save(category);
    }
}
