package com.demo.backend.repositories;

import com.demo.backend.model.AttendanceEntity;
import org.springframework.data.repository.CrudRepository;

public interface AssemblyRepository  extends CrudRepository<AttendanceEntity,Long> {
}
