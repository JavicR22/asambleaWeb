package com.demo.backend.repositories;

import com.demo.backend.model.PersonEntity;
import com.demo.backend.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(PersonEntity username);


}
