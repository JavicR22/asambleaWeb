package com.demo.backend.repositories;


import com.demo.backend.model.AssemblyEntity;
import com.demo.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface AssemblyRepository  extends JpaRepository<AssemblyEntity,Long> {

    @Query("SELECT a.attendances FROM AssemblyEntity a WHERE a.assembly_id =:assemblyId")
    Set<UserEntity> findAttendanceByAssemblyId(@Param("assemblyId")Long assemblyId);
}
