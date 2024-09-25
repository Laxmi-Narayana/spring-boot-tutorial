package com.laxminarayanagellu.spring_boot_starter.service;

import com.laxminarayanagellu.spring_boot_starter.entity.Department;
import com.laxminarayanagellu.spring_boot_starter.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    Boolean deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId,Department department) throws DepartmentNotFoundException;

    List<Department> getDepartmentsByName(String departmentName);
}
