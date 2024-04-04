package com.demo.backend.repositories;


import com.demo.backend.model.AssemblyEntity;
import org.springframework.data.repository.CrudRepository;

public interface AssemblyRepository  extends CrudRepository<AssemblyEntity,Long> {
}
