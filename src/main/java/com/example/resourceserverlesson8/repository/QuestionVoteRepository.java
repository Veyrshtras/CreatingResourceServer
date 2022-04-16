package com.example.resourceserverlesson8.repository;
import com.example.resourceserverlesson8.entity.QuestionVote;
import com.example.resourceserverlesson8.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionVoteRepository extends BaseRepository<QuestionVote>{
    Optional<QuestionVote> findByQuestion_IdAndCreatedByAndDeletedFalse(Long questionId, User user);
}
