package com.cognizant.ormlearnformapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearnformapping.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
