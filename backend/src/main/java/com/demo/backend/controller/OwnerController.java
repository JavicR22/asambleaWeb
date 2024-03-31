package com.demo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {


    @GetMapping("/casa")
    public String casa(){
        return "casa";
    }

    @GetMapping("/example")
    public ResponseEntity<String> exampleMethod(@RequestHeader("Nombre") String authorizationHeader) {
        // Aquí puedes usar el valor del encabezado "Authorization"
        System.out.println("Valor del encabezado Authorization: " + authorizationHeader);

        // Tu lógica de negocio aquí

        return ResponseEntity.ok("Encabezado recibido correctamente");
    }


    }
