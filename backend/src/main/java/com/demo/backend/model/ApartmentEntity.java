package com.demo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "apartments")
public class ApartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long apartment_id;

    @NotBlank
    private int tower;

    @NotBlank
    private int apartment_number;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private PersonEntity owner;

}
