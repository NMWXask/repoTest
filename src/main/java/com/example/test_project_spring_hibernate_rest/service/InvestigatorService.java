package com.example.test_project_spring_hibernate_rest.service;

import com.example.test_project_spring_hibernate_rest.database.Investigator;
import com.example.test_project_spring_hibernate_rest.dto.InvestigatorRequestDto;
import com.example.test_project_spring_hibernate_rest.dto.InvestigatorResponseDto;
import com.example.test_project_spring_hibernate_rest.exceptions.NotFoundInvestigatorException;

import java.util.List;
import java.util.Optional;

public interface InvestigatorService {
    Optional<Investigator> findById(Long id);

    InvestigatorResponseDto save(InvestigatorRequestDto dto);

    Investigator update(String uuid, InvestigatorRequestDto requestDto) throws NotFoundInvestigatorException;

   List<Investigator> findAll();
}
