package com.example.test_project_spring_hibernate_rest.service.impl;

import com.example.test_project_spring_hibernate_rest.database.Department;
import com.example.test_project_spring_hibernate_rest.dto.DepartmentResponseDto;
import com.example.test_project_spring_hibernate_rest.repository.DepartmentRepository;
import com.example.test_project_spring_hibernate_rest.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponseDto> findAll() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponseDto> departmentResponseDtos = departments.stream()
                .map(department -> DepartmentResponseDto.builder()
                        .name(department.getDepartmentName())
                        .build()).collect(Collectors.toList());
        return departmentResponseDtos;
    }
}
