package com.cognizant.ormlearnformapping.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearnformapping.exception.FoundException;
import com.cognizant.ormlearnformapping.model.Employee;
import com.cognizant.ormlearnformapping.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	//handson 4
	@Transactional
	public Employee get(int id) throws FoundException {

		LOGGER.info("GET by ID method in EmployeeService Start");

		 Optional<Employee> findById = employeeRepository.findById(id);
		 if(!findById.isPresent()){
			 throw new FoundException("not found");
		 }
		 return findById.get();

	}
	
	//handson 4
	@Transactional
	public void save(Employee employee) {

		LOGGER.info("save method in EmployeeService Start");

		Employee save = employeeRepository.save(employee);

		LOGGER.debug("Employee:{}", save);

		LOGGER.info("save method in EmployeeService End");

	}
}
