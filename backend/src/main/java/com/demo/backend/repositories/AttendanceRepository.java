package com.demo.backend.repositories;

import com.demo.backend.model.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository  extends JpaRepository<AttendanceEntity,Long> {
}
