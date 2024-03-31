package com.demo.backend.repositories;

import com.demo.backend.model.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity,Long> {
}
