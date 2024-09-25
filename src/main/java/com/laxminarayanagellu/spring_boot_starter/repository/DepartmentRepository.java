package com.laxminarayanagellu.spring_boot_starter.repository;

import com.laxminarayanagellu.spring_boot_starter.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> findAllByDepartmentName(String departmentName);
}
