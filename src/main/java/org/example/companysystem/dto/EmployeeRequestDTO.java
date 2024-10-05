package org.example.companysystem.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeRequestDTO {
    private UUID id;
    private String name;
    private String function;
    private String status;
}
