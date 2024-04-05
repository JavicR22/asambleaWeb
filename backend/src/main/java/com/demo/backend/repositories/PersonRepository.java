package com.demo.backend.repositories;


import com.demo.backend.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query("SELECT p FROM  PersonEntity p WHERE p.id_person=?1")
    Optional<PersonEntity> getName(Long id);

}
