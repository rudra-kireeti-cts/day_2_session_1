package com.cognizant.ormlearnformapping.services;

import com.cognizant.ormlearnformapping.model.Employee;

public interface EmployeeService {

	public Employee getById(int id);

	public void save(Employee employee);

}
