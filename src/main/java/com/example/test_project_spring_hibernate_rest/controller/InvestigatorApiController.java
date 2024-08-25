package com.example.test_project_spring_hibernate_rest.controller;

import com.example.test_project_spring_hibernate_rest.database.Investigator;
import com.example.test_project_spring_hibernate_rest.dto.InvestigatorRequestDto;
import com.example.test_project_spring_hibernate_rest.dto.InvestigatorResponseDto;
import com.example.test_project_spring_hibernate_rest.exceptions.NotFoundInvestigatorException;
import com.example.test_project_spring_hibernate_rest.service.InvestigatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/investigator")
public class InvestigatorApiController {

    private final InvestigatorService investigatorService;

    @GetMapping
    public ResponseEntity<List<Investigator>> findAll(){
        return new ResponseEntity<>(investigatorService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investigator> findById(@PathVariable Long id) throws NotFoundInvestigatorException {
        return investigatorService.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundInvestigatorException("Not finded"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvestigatorResponseDto> addInvestigator(@RequestBody InvestigatorRequestDto requestDto) {
        return new ResponseEntity<>(investigatorService.save(requestDto), HttpStatus.OK);
    }

    @PutMapping(path = "/{uuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Investigator> update(@PathVariable(name = "uuid") String uuid,
                                               @RequestBody InvestigatorRequestDto requestDto) throws NotFoundInvestigatorException {
        Investigator updateRequest = investigatorService.update(uuid,requestDto);
        return new ResponseEntity<>(updateRequest, HttpStatus.OK);
    }

}
