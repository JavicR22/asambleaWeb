package com.demo.backend.service;

import com.demo.backend.DTO.AssemblyDTO;
import com.demo.backend.model.AssemblyEntity;
import com.demo.backend.model.EState;
import com.demo.backend.model.UserEntity;
import com.demo.backend.repositories.AssemblyRepository;
import com.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class AssemblyService{
    @Autowired
    private AssemblyRepository assemblyRepository;

    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity;

    @Transactional
    public String scheduleAppointment(AssemblyDTO assemblyDTO){

        EState eState = EState.SCHEDULED;
        AssemblyEntity assemblyScheduled = AssemblyEntity.builder()
                .issue(assemblyDTO.getIssue())
                .date(assemblyDTO.getDate())
                .state(EState.SCHEDULED.name())
                .start_time(assemblyDTO.getStartTime())
                .build();


        assemblyRepository.save(assemblyScheduled);
        return "Assembly scheduled";
    }

    public String takeAssistance(String username, long idAssambly){
        Optional<UserEntity> assistedOwnerOptional = userRepository.findByUsernameAndOwnerRole(username);
        Optional<AssemblyEntity> assemblyOptional = assemblyRepository.findById(idAssambly);

        if(assistedOwnerOptional.isPresent() && assemblyOptional.isPresent()){

            AssemblyEntity assembly = assemblyOptional.get();
            UserEntity assistedOwner = assistedOwnerOptional.get();
            Set<UserEntity> assistedOwners = assemblyRepository.findAttendanceByAssemblyId(idAssambly);
            if(assistedOwners.contains(assistedOwner)){
                return "Ya se le ha tomado la asistencia al propietario";

            }else {
                assembly.getAttendances().add(assistedOwner);
                assemblyRepository.save(assembly);
                return "Asistencia efectuada exitosamente";
            }
        }else{
            return "Propietario no existe o no es un propietario";
        }
    }



    public boolean validateStartAssembly(long idAssambly){

        Set<UserEntity> assistedOwners = assemblyRepository.findAttendanceByAssemblyId(idAssambly);

        Set<UserEntity> allOwners = userRepository.findOwners();

        int totalAssistedOwners = assistedOwners.size();
        int totalAllOwners = allOwners.size();

        double attendancePercentage = ((double) totalAssistedOwners / totalAllOwners) * 100;

        if (attendancePercentage > 51) {
            return true;
        }
        else {
            return false;
        }

    }


}
