package com.demo.backend.controller;

import com.demo.backend.model.*;
import com.demo.backend.service.AssemblyService;
import com.demo.backend.service.PersonService;
import com.demo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AttendanceController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AssemblyService assemblyService;

    @Autowired
    private UserService userService;

    /*
    @PostMapping("/attendances")
    public ResponseEntity<?> createAttendance(@RequestBody AttendanceDTO request) {
        AttendanceEntity attendance = new AttendanceEntity();
        PersonEntity owner = personService.getPersonById(request.getOwnerId());
        AssemblyEntity assembly = assemblyService.getAssemblyById(request.getAssemblyId());
        attendance.setDate(request.getDate());
        attendance.setOwner(owner);
        attendance.setAssembly(assembly);
        attendanceService.createAttendance(attendance);
        return ResponseEntity.ok("Attendance created successfully");
    }

     */

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/Owners")
    public ResponseEntity<Set<UserEntity>> owners(){

        return ResponseEntity.ok(userService.findOwners());
    }

}