package com.demo.backend.DTO;

import com.demo.backend.model.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssemblyDTO {


    private String issue;
    private String date;
    private String startTime;
    private EState state;
}
