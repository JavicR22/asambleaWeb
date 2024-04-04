package com.demo.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<AttendanceEntity> attendances;

}
