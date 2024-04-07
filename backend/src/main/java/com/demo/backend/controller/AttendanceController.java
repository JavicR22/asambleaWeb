package com.demo.backend.controller;

import com.demo.backend.model.*;
import com.demo.backend.service.AssemblyService;
import com.demo.backend.service.AttendanceService;
import com.demo.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private PersonService personService;

    @Autowired
    private AssemblyService assemblyService;

    @PostMapping("/attendances")
    public ResponseEntity<?> createAttendance(@RequestBody AttendanceRequest request) {
        AttendanceEntity attendance = new AttendanceEntity();
        PersonEntity owner = personService.getPersonById(request.getOwnerId());
        AssemblyEntity assembly = assemblyService.getAssemblyById(request.getAssemblyId());
        attendance.setDate(request.getDate());
        attendance.setOwner(owner);
        attendance.setAssembly(assembly);
        attendanceService.createAttendance(attendance);
        return ResponseEntity.ok("Attendance created successfully");
    }
}