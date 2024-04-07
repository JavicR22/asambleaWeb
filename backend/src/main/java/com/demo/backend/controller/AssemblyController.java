package com.demo.backend.controller;

import com.demo.backend.model.AssemblyEntity;
import com.demo.backend.model.AssemblyRequest;
import com.demo.backend.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssemblyController{

    @Autowired
    private AssemblyService assemblyService;

    @PostMapping("/assemblies")
    public ResponseEntity<String> createAssembly(@RequestBody AssemblyRequest request) {

        AssemblyEntity assembly = new AssemblyEntity();
        assembly.setDate(request.getDate());
        assembly.setStart_time(request.getStartTime());
        assembly.setFinish_time(request.getFinishTime());

        assemblyService.createAssembly(assembly);

        return ResponseEntity.status(HttpStatus.CREATED).body("Assembly created successfully");
    }
}
