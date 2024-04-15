package com.demo.backend.service;

import com.demo.backend.model.UserEntity;
import com.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Set<UserEntity> findOwners(){
        return userRepository.findOwners();

    }

    public Optional<UserEntity> findOwner(String username){
        return userRepository.findByUsernameAndOwnerRole(username);
    }
}
