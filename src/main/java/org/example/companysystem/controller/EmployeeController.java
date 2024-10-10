package org.example.companysystem.controller;

import lombok.AllArgsConstructor;
import org.example.companysystem.dto.EmployeeRequestDTO;
import org.example.companysystem.dto.EmployeeResponseDTO;
import org.example.companysystem.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable UUID id){
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeByName(@RequestParam String name){
        return ResponseEntity.ok(employeeService.findEmployeeByName(name));
    }

    @GetMapping("/function")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeByFunction(@RequestParam String function){
        return ResponseEntity.ok(employeeService.findEmployeeByFunction(function));
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeRequestDTO employee){
        return ResponseEntity.status(201).body(employeeService.saveEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@RequestBody EmployeeRequestDTO employee){
        return ResponseEntity.status(201).body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
