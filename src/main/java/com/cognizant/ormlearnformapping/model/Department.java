package com.cognizant.ormlearnformapping.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "department")
@Table(name = "department", schema = "ormlearn")
public class Department {

	// day 2 handson 3 declaring the variables, annotions and creating repo's
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dp_id")
	private int id;

	@Column(name = "dp_name")
	private String name;
	
	//handson 5
	@OneToMany(mappedBy = "department")
	//@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private Set<Employee> employeeList;
}
