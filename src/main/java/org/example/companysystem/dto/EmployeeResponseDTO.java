package org.example.companysystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EmployeeResponseDTO {
    private UUID id;
    private String name;
    private LocalDate birthDate;
    private String function;
    private String salary;
    private String status;
    private LocalDateTime admissionDate;
}