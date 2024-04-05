package com.demo.backend.service;

import com.demo.backend.model.PersonEntity;
import com.demo.backend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonEntity getPersonById(Long personId) {
        return personRepository.findById(personId).orElse(null);
    }
    public String getInfoUser(long id){

        Optional <PersonEntity> personOptional = personRepository.findById(id);

        PersonEntity personFind = personOptional.orElseThrow(() -> new NoSuchElementException("Person not found"));

        String personInfo;
        personInfo = personFind.getFirstName()+" "+personFind.getFirstLastname();


        return personInfo;
    }


}
