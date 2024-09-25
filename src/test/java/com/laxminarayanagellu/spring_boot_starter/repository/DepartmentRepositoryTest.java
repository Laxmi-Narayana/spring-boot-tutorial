package com.laxminarayanagellu.spring_boot_starter.repository;

import com.laxminarayanagellu.spring_boot_starter.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//@TestPropertySource(locations = "classpath:application-test.properties")
//Add h2 scope test else it throws exception while creating entity manager object
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Prevent replacing the database
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Computer Science")
                .departmentCode("CM-001")
                .departmentAddress("HYDERABAD")
                .build();
        entityManager.persist(department);
    }

    @Test
    public void whenDepartmentById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        System.out.println(department.getDepartmentName());
        assertEquals(department.getDepartmentName(),"Computer Science");
    }
}