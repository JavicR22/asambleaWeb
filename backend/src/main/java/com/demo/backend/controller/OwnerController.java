package com.demo.backend.controller;

import com.demo.backend.model.UserEntity;
import com.demo.backend.service.PersonService;
import com.demo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class OwnerController {
    @Autowired
    private PersonService personService;

    @Autowired
    private UserService userService;
    @GetMapping("/info/user")
    public ResponseEntity<String> infoUser(@RequestHeader("username") String authorizationHeader) {
        String personInfo;
        personInfo = personService.getInfoUser(Long.parseLong(authorizationHeader));
        return ResponseEntity.ok(personInfo);
    }

    @GetMapping("/hole")
    public String hole(@RequestHeader("username") String authorizationHeader){
        return "holiiss";
    }
}
