package com.demo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "person")
public class PersonEntity {

    public PersonEntity(String id_person) {
        this.id_person = id_person;
    }

    @Id
    @NotBlank
    @Size(max=12)
    private String id_person;

    @NotBlank
    @Size(max=16)
    private String firstName;

    @Size(max=16)
    private String secondName;

    @NotBlank
    @Size(max=16)
    private String FirstLastname;

    @NotBlank
    @Size(max=16)
    private String SecondLastname;

    @NotBlank
    @Size(max=45)
    private String address;

    @Email
    @NotBlank
    @Size(max=50)
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @NotBlank
    private List<ApartmentEntity> apartments;




}