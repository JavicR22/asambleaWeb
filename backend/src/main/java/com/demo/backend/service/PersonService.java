package com.demo.backend.service;

import com.demo.backend.model.PersonEntity;
import com.demo.backend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public String getNames(){
        return "dssd";
    }


}
