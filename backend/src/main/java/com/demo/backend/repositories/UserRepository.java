package com.demo.backend.repositories;

import com.demo.backend.model.PersonEntity;
import com.demo.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(PersonEntity username);


}
