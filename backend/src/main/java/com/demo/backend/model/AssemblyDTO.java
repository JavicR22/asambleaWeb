package com.demo.backend.model;

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
    private String finishTime;
}
