package com.laxminarayanagellu.spring_boot_starter.service;

import com.laxminarayanagellu.spring_boot_starter.entity.Department;
import com.laxminarayanagellu.spring_boot_starter.error.DepartmentNotFoundException;
import com.laxminarayanagellu.spring_boot_starter.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
//        return department.orElseGet(Department::new);
    }

    @Override
    public Boolean deleteDepartmentById(Long departmentId) {
        if(departmentRepository.findById(departmentId).isPresent()) {
            departmentRepository.deleteById(departmentId);
            return true;
        }
        return false;
    }

    @Override
    public Department updateDepartmentById(Long departmentId,Department department) throws DepartmentNotFoundException {
        Optional<Department> departmentOld = departmentRepository.findById(departmentId);
        if(departmentOld.isEmpty()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }
//            not null and not empty then update
        if(Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().trim().isEmpty()) {
            departmentOld.get().setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !department.getDepartmentAddress().trim().isEmpty()) {
            departmentOld.get().setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !department.getDepartmentCode().trim().isEmpty()) {
            departmentOld.get().setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(departmentOld.get());
    }

    @Override
    public List<Department> getDepartmentsByName(String departmentName) {
        return departmentRepository.findAllByDepartmentName(departmentName);
    }
}
