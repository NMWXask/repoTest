package com.example.test_project_spring_hibernate_rest.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record InvestigatorRequestDto(
        String name,
        String surname,
        Long departmentId,
        String city
) implements Serializable {
}
