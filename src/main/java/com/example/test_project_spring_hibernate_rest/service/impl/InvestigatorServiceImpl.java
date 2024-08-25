package com.example.test_project_spring_hibernate_rest.service.impl;

import com.example.test_project_spring_hibernate_rest.database.Investigator;
import com.example.test_project_spring_hibernate_rest.dto.InvestigatorRequestDto;
import com.example.test_project_spring_hibernate_rest.dto.InvestigatorResponseDto;
import com.example.test_project_spring_hibernate_rest.exceptions.NotFoundInvestigatorException;
import com.example.test_project_spring_hibernate_rest.repository.InvestigatorRepository;
import com.example.test_project_spring_hibernate_rest.service.InvestigatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvestigatorServiceImpl implements InvestigatorService {
    private final InvestigatorRepository investigatorRepository;
    @Override
    public Optional<Investigator> findById(Long id) {
        return investigatorRepository.findById(id);
    }

    @Override
    public InvestigatorResponseDto save(InvestigatorRequestDto dto) {
        Investigator investigator = Investigator.builder()
                .uuid(String.valueOf(UUID.fromString(UUID.randomUUID().toString())))
                .name(dto.name())
                .surname(dto.surname())
                .city(dto.city())
                .build();
        investigatorRepository.save(investigator);

        return InvestigatorResponseDto.builder()
                .uuid(investigator.getUuid())
                .name(investigator.getName())
                .surname(investigator.getSurname())
                .city(investigator.getCity())
                .build();
    }

    @Override
    public Investigator update(String uuid, InvestigatorRequestDto requestDto) throws NotFoundInvestigatorException {
        Optional<Investigator>investigatorOptional = Optional.ofNullable(investigatorRepository.findByUuid(uuid));
        if (investigatorOptional.isPresent()) {
            Investigator investigator = investigatorOptional.get();

            if (requestDto.name() != null && !requestDto.name().equals(investigator.getName())) {
                investigator.setName(requestDto.name());
            }
            if (requestDto.surname() != null && !requestDto.surname().equals(investigator.getSurname())) {
                investigator.setSurname(requestDto.surname());
            }
//            if (requestDto.departmentId() != null && !requestDto.departmentId().equals(investigator.getDepartment_id())) {
//                investigator.setDepartment_id(requestDto.departmentId());
//            }
            if (requestDto.city() != null && !requestDto.city().equals(investigator.getCity())) {
                investigator.setCity(requestDto.city());
            }

            return investigatorRepository.save(investigator);
        }
        else {
            throw new NotFoundInvestigatorException("Investigator with ID " + uuid + " not found");
        }
    }

    @Override
    public List<Investigator> findAll() {
        return investigatorRepository.findAll();
    }
}
