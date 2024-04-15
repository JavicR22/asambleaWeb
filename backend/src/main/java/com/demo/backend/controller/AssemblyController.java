package com.demo.backend.controller;

import com.demo.backend.model.AssemblyEntity;
import com.demo.backend.DTO.AssemblyDTO;
import com.demo.backend.security.Auth0.JwtToAccessTokenConverter;
import com.demo.backend.service.AssemblyService;
import com.demo.backend.service.CalendarService;
import com.google.api.services.calendar.model.Event;
import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssemblyController{

    @Autowired
    private AssemblyService assemblyService;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    JwtToAccessTokenConverter jwtToAccessTokenConverter;
/*
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/assemblies")
    public ResponseEntity<String> createAssembly(@RequestBody AssemblyDTO request) {

        AssemblyEntity assembly = new AssemblyEntity();
        assembly.setDate(request.getDate());
        assembly.setStart_time(request.getStartTime());
        assembly.setFinish_time(request.getFinishTime());

        assemblyService.createAssembly(assembly);

        return ResponseEntity.status(HttpStatus.CREATED).body("Assembly created successfully");
    }
*/

    @PostMapping("/event")
    public ResponseEntity<String> createEvent(@RequestHeader("Authorization") String jwtToken, @RequestBody Event event) {
        try {
            // Aquí puedes extraer el token JWT de la cabecera de autorización y realizar el intercambio por un token de acceso OAuth2
            String accessToken = jwtToAccessTokenConverter.exchangeJwtForAccessToken(jwtToken);

            // Luego puedes usar el token de acceso para crear el evento en Google Calendar
            calendarService.createEvent(accessToken, event);

            return ResponseEntity.ok("Event created successfully.");
        } catch (IOException | java.io.IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create event.");
        }
    }
    /*
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/assemblies")
    public ResponseEntity<String> createAttendance(@RequestBody AttendanceDTO request) {

        AssemblyEntity assembly = new AssemblyEntity();
        assembly.setDate(request.getDate());
        assembly.setStart_time(request.getStartTime());
        assembly.setFinish_time(request.getFinishTime());

        assemblyService.createAssembly(assembly);

        return ResponseEntity.status(HttpStatus.CREATED).body("Assembly created successfully");
    }
*/
}
