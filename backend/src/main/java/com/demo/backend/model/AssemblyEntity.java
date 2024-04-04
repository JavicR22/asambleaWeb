package com.demo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity
@Table(name = "assemblies")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssemblyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long assembly_id;

    @OneToMany(mappedBy = "assembly", cascade = CascadeType.ALL)
    @NotBlank
    private List<AttendanceEntity> attendances;

    @DateTimeFormat
    @NotBlank
    private String date;

    @DateTimeFormat
    @NotBlank
    private String start_time;

    @DateTimeFormat
    @NotBlank
    private String finish_time;





}
