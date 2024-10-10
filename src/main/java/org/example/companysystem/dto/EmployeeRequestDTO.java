package org.example.companysystem.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EmployeeRequestDTO {
    private UUID id;
    private String name;
    private LocalDate birthDate;
    private String salary;
    private String function;
}
