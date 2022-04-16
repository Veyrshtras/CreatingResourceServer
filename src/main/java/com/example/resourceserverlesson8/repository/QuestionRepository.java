package com.example.resourceserverlesson8.repository;

import com.example.resourceserverlesson8.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository

public interface QuestionRepository extends BaseRepository<Question>{

    Page<Question> findAllByCategory_Id(Long category_id, Pageable pageable);
}
