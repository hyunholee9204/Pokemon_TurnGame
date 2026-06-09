package com.example.Loguelike_Pokemon.Repository;

import com.example.Loguelike_Pokemon.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    // 중복체크
    Optional<UserEntity> findByUserId(String userId);
    boolean existsByNickname(String nickname);
}
