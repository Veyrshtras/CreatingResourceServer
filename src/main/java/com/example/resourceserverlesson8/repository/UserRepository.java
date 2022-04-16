package com.example.resourceserverlesson8.repository;

import com.example.resourceserverlesson8.entity.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    Optional<User> findByEmail(String email);
}
