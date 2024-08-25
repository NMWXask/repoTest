package com.example.test_project_spring_hibernate_rest.service;

import com.example.test_project_spring_hibernate_rest.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponseDto>findAll();
}
