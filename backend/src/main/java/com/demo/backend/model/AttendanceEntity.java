package com.demo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "attendances")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attendance_id;

    @OneToOne
    @JoinColumn(name = "username")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "assembly_id")
    private AssemblyEntity assembly;

    @DateTimeFormat
    @NotBlank
    private String date;

}
