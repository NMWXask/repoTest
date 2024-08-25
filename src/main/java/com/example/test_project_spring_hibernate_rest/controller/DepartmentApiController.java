package com.example.test_project_spring_hibernate_rest.controller;

import com.example.test_project_spring_hibernate_rest.dto.DepartmentResponseDto;
import com.example.test_project_spring_hibernate_rest.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentApiController {

    private final DepartmentService departmentService;

    @GetMapping
    ResponseEntity<List<DepartmentResponseDto>> findAll(){
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }
}
