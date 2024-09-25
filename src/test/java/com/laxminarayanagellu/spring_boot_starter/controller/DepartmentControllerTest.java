package com.laxminarayanagellu.spring_boot_starter.controller;

import com.laxminarayanagellu.spring_boot_starter.entity.Department;
import com.laxminarayanagellu.spring_boot_starter.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//Need to hit api end points hence need to mock contest
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("ITIS")
                .departmentAddress("Hyderabad")
                .departmentCode("GLN-1")
                .departmentId(1L)
                .build();
    }

    @Test
    @DisplayName("Testing Get By Id")
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentId").value(department.getDepartmentId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("ITIS")
                .departmentAddress("Hyderabad")
                .departmentCode("GLN-1")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"ITIS\",\n" +
                        "    \"departmentAddress\":\"Hyderabad\",\n" +
                        "    \"departmentCode\":\"GLN-1\"\n" +
                        "}")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}