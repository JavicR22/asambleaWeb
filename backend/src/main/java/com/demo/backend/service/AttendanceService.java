package com.demo.backend.service;

import com.demo.backend.model.AttendanceEntity;
import com.demo.backend.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService{

    @Autowired
    private AttendanceRepository attendanceRepository;

    public ResponseEntity<String> createAttendance(AttendanceEntity attendance) {

        attendanceRepository.save(attendance);

        return ResponseEntity.status(HttpStatus.CREATED).body("Attendance created successfully");
    }
}
