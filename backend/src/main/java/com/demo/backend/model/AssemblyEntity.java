package com.demo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.Set;

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

    @NotBlank
    @Size(max = 170)
    private  String issue;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = UserEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "attendances", joinColumns = @JoinColumn(name="assembly_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserEntity> attendances;


    @NotBlank
    @Enumerated(EnumType.STRING)
    private EState state;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private String date;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @NotBlank
    private String start_time;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @NotBlank
    private String finish_time;





}
