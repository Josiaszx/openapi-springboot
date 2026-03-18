package com.openapi.test.controller;

import com.openapi.test.model.Employee;
import com.openapi.test.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Enfoque Design First - la documentación de OpenAPI primero se define en yaml y luego se implementa el codigo
 * según lo definido. Todo se describe en el archivo src/main/resources/static/openapi.yaml, por lo que no se debe dar
 * descripciones de la documentación dentro del código.
*/

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    final private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found"));
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}