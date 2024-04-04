package com.demo.backend.repositories;

import com.demo.backend.model.ApartmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository  extends CrudRepository<ApartmentEntity,Long> {
}
