package com.demo.backend.repositories;


import com.demo.backend.model.AssemblyEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssemblyRepository  extends JpaRepository<AssemblyEntity,Long> {
}
