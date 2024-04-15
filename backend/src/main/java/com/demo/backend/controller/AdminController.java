package com.demo.backend.controller;

import com.demo.backend.DTO.AssemblyDTO;
import com.demo.backend.model.UserEntity;
import com.demo.backend.service.AssemblyService;
import com.demo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    AssemblyService assemblyService;

    @Autowired
    UserService userService;


    @PostMapping("/assembly/scheduled")
    public ResponseEntity<String> assemblyScheduled(@RequestBody AssemblyDTO assemblyDTO) {




        assemblyService.scheduleAppointment(assemblyDTO);

        return ResponseEntity.ok("sa");
        // Enviar una respuesta exitosa

    }

    @GetMapping("/find/owner")
    public ResponseEntity<String> findOwner(){

        Optional<UserEntity> findOwner =userService.findOwner("1");

        if(findOwner.isPresent()){
            return ResponseEntity.ok("Propietario Encontrado");
        }
        else{
            return ResponseEntity.ok("Propietario no Encontrado");
        }


    }
    @GetMapping("/take/assist")
    public ResponseEntity<String>takeAssist(){
        return ResponseEntity.ok(assemblyService.takeAssistance("1",1));
    }

}

