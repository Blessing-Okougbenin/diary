package com.mine.diary.data.repository;

import com.mine.diary.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

       Optional<User> findByEmail(String email);
}
