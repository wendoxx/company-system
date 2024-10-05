package org.example.companysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeRepository, UUID> {
    EmployeeRepository findByName(String name);
    EmployeeRepository findByFunction(String function);
    EmployeeRepository findByStatus(String status);
}
