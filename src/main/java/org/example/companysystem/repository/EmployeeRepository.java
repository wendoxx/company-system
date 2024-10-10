package org.example.companysystem.repository;

import org.example.companysystem.model.EmployeeModel;
import org.example.companysystem.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {
    Optional<EmployeeRepository> findByName(String name);
    Optional<EmployeeRepository> findByFunction(String function);
}
