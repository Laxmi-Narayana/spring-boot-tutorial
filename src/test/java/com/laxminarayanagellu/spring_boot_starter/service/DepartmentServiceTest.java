package com.laxminarayanagellu.spring_boot_starter.service;

import com.laxminarayanagellu.spring_boot_starter.entity.Department;
import com.laxminarayanagellu.spring_boot_starter.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentAddress("Hyderabad")
                .departmentName("IT")
                .departmentCode("GLN-01")
                .build();
        Mockito.when(departmentService.getDepartmentsByName("IT")).thenReturn(List.of(department));
    }

    @Test
    @DisplayName("Get Data based on valid Department name")
    void getDepartmentsByName() {
        String departmentName = "IT";
        List<Department> departmentList = departmentService.getDepartmentsByName(departmentName);
        Department found = departmentList.get(0);
        assertEquals(found.getDepartmentName(), departmentName);

    }
}