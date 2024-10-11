package org.example.companysystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.companysystem.service.EmployeeStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_employee")
@EqualsAndHashCode
public class EmployeeModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "status")
    private EmployeeStatus status;

    @Column(name = "salary", nullable = false)
    private String salary;

    @Column(name = "admission_date")
    private LocalDateTime admissionDate = LocalDateTime.now();

    @Column(name = "function", nullable = false)
    private String function;
}