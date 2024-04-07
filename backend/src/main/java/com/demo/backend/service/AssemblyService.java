package com.demo.backend.service;

import com.demo.backend.model.AssemblyEntity;
import com.demo.backend.repositories.AssemblyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyService{
    @Autowired
    private AssemblyRepository assemblyRepository;
    public void createAssembly(AssemblyEntity assembly) {
        assemblyRepository.save(assembly);
    }

    public AssemblyEntity getAssemblyById(long assemblyId) {
        return assemblyRepository.findById(assemblyId).orElse(null);
    }
}
