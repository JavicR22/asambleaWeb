package com.demo.backend.repositories;

import com.demo.backend.model.ApartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository  extends JpaRepository<ApartmentEntity,Long> {
}
