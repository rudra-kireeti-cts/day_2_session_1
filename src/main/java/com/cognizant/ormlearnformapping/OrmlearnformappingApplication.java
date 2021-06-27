package com.cognizant.ormlearnformapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmlearnformappingApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		// testGetEmployee();
		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		// testAddSkillToEmployee();
		// getAllPermanent();
		// getAverageSalary();
		// getAverageSalaryByDept();
		usingNative();
	}

	private static void testGetEmployee() {

		LOGGER.info("Start testGetEmployee");

		Employee employee = employeeService.getById(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());

		LOGGER.info("End testGetEmployee");

	}

	// handson 4
	private static void testAddEmployee() {
		LOGGER.info("Start testAddEmployee");

		Department department = departmentService.getById(1);
		Employee employee = Employee.builder().name("kireeti").salary(BigDecimal.valueOf(30000)).permanent(true)
				.dateOfBirth(new Date(2021, 03, 23)).department(department).build();
		employeeService.save(employee);

		LOGGER.info("End testAddEmployee");
	}

	// handson 4
	private static void testUpdateEmployee() {

		LOGGER.info("Start testUpdateEmployee");

		Employee employee = employeeService.getById(1);
		Department department = departmentService.getById(2);
		employee.setDepartment(department);
		employeeService.save(employee);

		LOGGER.info("End testUpdateEmployee");
	}

	// hand'son 5
	private static void testGetDepartment() {
		LOGGER.info("Start testGetDepartment");

		Department department = departmentService.getById(3);
		department.getEmployeeList().forEach(emp -> System.out.println(emp));

		LOGGER.info("End testGetDepartment");
	}

	// hand'son 6
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start testAddSkillToEmployee");

		Employee employee = employeeService.getById(1);
		Skill skill = skillService.getById(2);
		employee.getSkillList().add(skill);
		employeeService.save(employee);

		LOGGER.info("End testAddSkillToEmployee");
	}

	// sesson2 hand'son 1
	private static void getAllPermanent() {
		LOGGER.info("Start getAllPermanent");

		List<Employee> all = employeeService.getAll();
		LOGGER.debug("{}", all);

		LOGGER.info("End getAllPermanent");
	}

	// session 2 hand'son 4
	private static void getAverageSalary() {
		LOGGER.info("Start getAverageSalary");

		double averageSalary = employeeService.getAverageSalary();
		LOGGER.debug("{}", averageSalary);

		LOGGER.info("End getAverageSalary");
	}

	// session 2 hand'son 4
	private static void getAverageSalaryByDept() {
		LOGGER.info("Start getAverageSalary");

		double averageSalary = employeeService.getAverageSalaryByDept(3);
		LOGGER.debug("{}", averageSalary);

		LOGGER.info("End getAverageSalary");
	}
	// session 2 hand'son 5
	private static void usingNative(){
		LOGGER.info("Start usingNative");
		
		  List<Employee> allEmployeesNative = employeeService.getAllEmployeesNative();
		LOGGER.debug("{}", allEmployeesNative);
		
		LOGGER.info("End usingNative");
	}

}
