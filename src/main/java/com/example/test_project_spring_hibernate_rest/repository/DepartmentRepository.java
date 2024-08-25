package com.example.test_project_spring_hibernate_rest.repository;

import com.example.test_project_spring_hibernate_rest.database.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
