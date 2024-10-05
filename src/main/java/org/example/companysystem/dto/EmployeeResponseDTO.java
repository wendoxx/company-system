package org.example.companysystem.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EmployeeResponseDTO {
    private UUID id;
    private String name;
    private LocalDateTime birthDate;
    private String function;
    private double salary;
    private String status;
    private LocalDateTime admissionDate;
}