package com.example.resourceserverlesson8.repository;

import com.example.resourceserverlesson8.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends BaseRepository<Category> {

    List<Category> findAllByParent_IdAndDeletedFalse(Long id);

}
