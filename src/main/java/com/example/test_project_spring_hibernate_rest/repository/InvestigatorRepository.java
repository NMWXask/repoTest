package com.example.test_project_spring_hibernate_rest.repository;

import com.example.test_project_spring_hibernate_rest.database.Investigator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestigatorRepository extends JpaRepository<Investigator, Long> {
    Investigator findByUuid(String uuid);
}
