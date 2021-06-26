package com.cognizant.ormlearnformapping;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearnformapping.model.Department;
import com.cognizant.ormlearnformapping.model.Employee;
import com.cognizant.ormlearnformapping.model.Skill;
import com.cognizant.ormlearnformapping.services.DepartmentService;
import com.cognizant.ormlearnformapping.services.EmployeeService;
import com.cognizant.ormlearnformapping.services.SkillService;

@SpringBootApplication
public class OrmlearnformappingApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnformappingApplication.class);

	@Autowired
	private static EmployeeService employeeService;

	@Autowired
	private static DepartmentService departmentService;

	@Autowired
	private static SkillService skillService;

	/*@Bean
	CommandLineRunner testGetEmployee() {
		LOGGER.info("Start testGetEmployee");
		return args -> {
			Employee employee = employeeService.getById(1);
			LOGGER.info("{}", employee);
			LOGGER.info("{}", employee.getDepartment());
			LOGGER.info("Skills:{}", employee.getSkillList());

			LOGGER.info("End testGetEmployee");
		};
	}*/

	

	
	  private static void testGetEmployee() {
	  
	  LOGGER.info("Start testGetEmployee");
	  
	  Employee employee = employeeService.getById(1);
	  
	LOGGER.debug("Employee:{}", employee);
	  
	  LOGGER.debug("Department:{}", employee.getDepartment());
	  
	  LOGGER.debug("Skills:{}", employee.getSkillList());
	  
	  LOGGER.info("End testGetEmployee");
	  
	  }
	  
	  
	 // handson 4 // Change all these to CommandLineRunners
	 
	  private static void testAddEmployee() {
	  
	  LOGGER.info("Start testAddEmployee");
	  
	  Department department = departmentService.getById(1);
	  
	  Employee employee =
	  Employee.builder().name("kireeti").salary(BigDecimal.valueOf(30000)).
	  permanent(true)
	  .dateOfBirth(Date.valueOf("2000/04/16")).department(department).build();
	  
	  
	  employee.setName("kireeti");
	  employee.setSalary(BigDecimal.valueOf(300000));
	  employee.setPermanent(true);
	  employee.setDateOfBirth(Date.valueOf("2000/04/16"));
	  employee.setDepartment(department);
	  
	  
	  employeeService.save(employee);
	  
	  LOGGER.info("End testAddEmployee"); }
	 
	  // handson 4 
	  private static void testUpdateEmployee() {
	 
	  LOGGER.info("Start testUpdateEmployee");
	  
	  Employee employee = employeeService.getById(1); Department department =
	  departmentService.getById(2); employee.setDepartment(department);
	  employeeService.save(employee);
	  
	  LOGGER.info("End testUpdateEmployee"); }
	  
	  // hand'son 5 
	  private static void testGetDepartment() {
	  LOGGER.info("Start testGetDepartment");
	  
	  Department department = departmentService.getById(3);
	  department.getEmployeeList().forEach(emp -> System.out.println(emp));
	  
	  LOGGER.info("End testGetDepartment"); 
	  }
	  
	  // hand'son 6
	  private static void testAddSkillToEmployee(){ LOGGER.info("Start testAddSkillToEmployee");
	  
	  Employee employee = employeeService.getById(1); 
	  Set<Skill> skillList =(Set<Skill>) skillService.getById(2); 
	  Set<Skill> skillList2 =employee.getSkillList(); 
	  skillList2.add((Skill) skillList);
	  employee.setSkillList(skillList2); employeeService.save(employee);
	  
	  LOGGER.info("End testAddSkillToEmployee"); }
	 

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmlearnformappingApplication.class, args);
		// testGetEmployee();
		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		 testAddSkillToEmployee();
	}

}
