package com.demo.backend.repositories;

import com.demo.backend.model.PersonEntity;
import com.demo.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(PersonEntity username);

    @Query("SELECT u FROM UserEntity u JOIN u.roles r WHERE u.username.id_person = :username AND r.name = 'OWNER'")
    Optional<UserEntity> findByUsernameAndOwnerRole(@Param("username") String username);


    @Query("SELECT u FROM UserEntity u JOIN u.roles r WHERE r.name = 'OWNER'")
    Set<UserEntity> findOwners();

}
