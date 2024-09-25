package com.laxminarayanagellu.spring_boot_starter.controller;

import com.laxminarayanagellu.spring_boot_starter.entity.Department;
import com.laxminarayanagellu.spring_boot_starter.error.DepartmentNotFoundException;
import com.laxminarayanagellu.spring_boot_starter.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/departments/{id}")
    public Boolean deleteDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department) throws DepartmentNotFoundException {
        return departmentService.updateDepartmentById(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public List<Department> getDepartmentsByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentsByName(departmentName);
    }
}
