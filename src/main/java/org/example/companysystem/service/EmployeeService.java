package org.example.companysystem.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.companysystem.dto.EmployeeRequestDTO;
import org.example.companysystem.dto.EmployeeResponseDTO;
import org.example.companysystem.model.EmployeeModel;
import org.example.companysystem.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);

    public EmployeeResponseDTO findEmployeeById(UUID id) {
        LOGGER.info("Finding employee...");
        EmployeeModel employeeModel = modelMapper.map(employeeRepository.findById(id)
                .orElseThrow(() -> {
                    LOGGER.error("Employee not found");
                    return new RuntimeException("Employee not found");
                }), EmployeeModel.class);
        LOGGER.info("Employee found");
        return modelMapper.map(employeeModel, EmployeeResponseDTO.class);
    }

    public EmployeeResponseDTO findEmployeeByName(String name) {
        LOGGER.info("Finding employee...");
        EmployeeModel employeeModel = modelMapper.map(employeeRepository.findByName(name)
                .orElseThrow(()-> {
                    LOGGER.error("Employee not found");
                    return new RuntimeException("Employee not found");
                }), EmployeeModel.class);

        LOGGER.info("Employee found");
        return modelMapper.map(employeeModel, EmployeeResponseDTO.class);
    }

    public EmployeeResponseDTO findEmployeeByFunction(String function) {
        LOGGER.info("Finding employee...");

        EmployeeModel employeeModel = modelMapper.map(employeeRepository.findByFunction(function)
                .orElseThrow(() -> {
                    LOGGER.error("Employee not found");
                    return new RuntimeException("Employee not found");
                }), EmployeeModel.class);
        LOGGER.info("Employee found");
        return modelMapper.map(employeeModel, EmployeeResponseDTO.class);
    }

    public List<EmployeeResponseDTO> findAllEmployees() {
        LOGGER.info("Finding all employees...");
        if (employeeRepository.findAll().isEmpty()) {
            LOGGER.error("No employees found");
            throw new RuntimeException("No employees found");
        }
        LOGGER.info("Employees found");
        return modelMapper.map(employeeRepository.findAll(), List.class);
    }

    @Transactional
    public EmployeeResponseDTO saveAndUpdateEmployee(EmployeeRequestDTO requestDTO) {

        EmployeeModel employee;

        if (requestDTO.getId() != null) {
            LOGGER.info("Updating employee...");
            employee = modelMapper.map(employeeRepository.findById(requestDTO.getId())
                    .orElseThrow(() -> {
                        LOGGER.error("Employee not found");
                        return new RuntimeException("Employee not found");
                    }), EmployeeModel.class);
        } else {
            LOGGER.info("Saving employee...");
            employee = new EmployeeModel();
        }

        employee.setName(requestDTO.getName());
        employee.setFunction(requestDTO.getFunction());
        employee.setBirthDate(requestDTO.getBirthDate());
        employee.setSalary(requestDTO.getSalary());

        return modelMapper.map(employeeRepository.save(employee), EmployeeResponseDTO.class);
    }

    @Transactional
    public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO requestDTO) {
        return saveAndUpdateEmployee(requestDTO);
    }

    @Transactional
    public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO requestDTO) {
        return saveAndUpdateEmployee(requestDTO);
    }

    public void deleteEmployee(UUID id) {
        LOGGER.info("Deleting employee...");
        employeeRepository.deleteById(id);
        LOGGER.info("Employee deleted");
    }
}
