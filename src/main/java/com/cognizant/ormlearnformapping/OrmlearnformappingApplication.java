package com.cognizant.ormlearnformapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cognizant.ormlearnformapping.model.Department;
import com.cognizant.ormlearnformapping.model.Employee;
import com.cognizant.ormlearnformapping.model.Skill;
import com.cognizant.ormlearnformapping.model.Stock;
import com.cognizant.ormlearnformapping.services.DepartmentService;
import com.cognizant.ormlearnformapping.services.EmployeeService;
import com.cognizant.ormlearnformapping.services.SkillService;
import com.cognizant.ormlearnformapping.services.StockService;

@SpringBootApplication
public class OrmlearnformappingApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnformappingApplication.class);

	@Autowired
	StockService stockService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	SkillService skillService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmlearnformappingApplication.class, args);

	}

	// session 2 hand'son 2
	@Bean
	CommandLineRunner testGetAllStocks() {
		return arg -> {
			LOGGER.info("START  testGetAllStocks");
			List<Stock> stocks = stockService.getAllStocks();
			LOGGER.debug("stocks = {}", stocks);
			LOGGER.info("END testGetAllStocks");
		};
	}

	// session 2 hand'son 2
	@Bean
	CommandLineRunner testGetStocksOfFBInSep2019() {
		return arg -> {
			LOGGER.info("START testGetStocksOfFBInSep2019");
			List<Stock> stocks = stockService.getStocksOfFBInSep2019();
			for (Stock stock : stocks) {
				LOGGER.debug("stocks = {}", stock);
			}
			LOGGER.info("END testGetStocksOfFBInSep2019");
		};
	}

	// session 2 hand'son 2
	@Bean
	CommandLineRunner testGetStocksOfGoogleGT1250() {
		return arg -> {
			LOGGER.info("START testGetStocksOfGoogleGT1250");
			List<Stock> stocks = stockService.getStocksOfGoogleGT1250();
			for (Stock stock : stocks) {
				LOGGER.debug("stocks = {}", stock);
			}
			LOGGER.info("END testGetStocksOfGoogleGT1250");
		};
	}

	// session 2 hand'son 2
	@Bean
	CommandLineRunner testGetTop3StocksByVolume() {
		return arg -> {
			LOGGER.info("START testGetTop3StocksByVolume");
			List<Stock> stocks = stockService.getTop3StocksByVolume();
			for (Stock stock : stocks) {
				LOGGER.debug("stocks = {}", stock);
			}
			LOGGER.info("END testGetTop3StocksByVolume");
		};
	}

	// session 2 hand'son 2
	@Bean
	CommandLineRunner test3LowestNetflixStocks() {
		return arg -> {
			LOGGER.info("START test3LowestNetflixStocks");
			List<Stock> stocks = stockService.get3LowestNetflixStocks();
			for (Stock stock : stocks) {
				LOGGER.debug("stocks = {}", stock);
			}
			LOGGER.info("END test3LowestNetflixStocks");
		};
	}

	// session 2 hand'son 2
	@Bean
	CommandLineRunner testGetEmployee() {
		return arg -> {

			LOGGER.info("Start testGetEmployee");

			Employee employee = employeeService.getById(1);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.debug("Department:{}", employee.getDepartment());
			LOGGER.debug("Skills:{}", employee.getSkillList());

			LOGGER.info("End testGetEmployee");
		};

	}

	// handson 4
	@Bean
	CommandLineRunner testAddEmployee() {
		return arg -> {

			LOGGER.info("Start testAddEmployee");

			Department department = departmentService.getById(1);
			Employee employee = Employee.builder().name("kireeti").salary(BigDecimal.valueOf(30000)).permanent(true)
					.dateOfBirth(new Date(2021, 03, 23)).department(department).build();
			employeeService.save(employee);

			LOGGER.info("End testAddEmployee");
		};
	}

	// handson 4
	@Bean
	CommandLineRunner testUpdateEmployee() {

		LOGGER.info("Start testUpdateEmployee");

		return arg -> {

			Employee employee = employeeService.getById(1);
			Department department = departmentService.getById(2);
			employee.setDepartment(department);
			employeeService.save(employee);

			LOGGER.info("End testUpdateEmployee");
		};
	}

	// hand'son 5
	@Bean
	CommandLineRunner testGetDepartment() {
		return arg -> {

			LOGGER.info("Start testGetDepartment");

			Department department = departmentService.getById(3);
			department.getEmployeeList().forEach(emp -> System.out.println(emp));

			LOGGER.info("End testGetDepartment");
		};
	}

	// hand'son 6
	@Bean
	CommandLineRunner testAddSkillToEmployee() {
		return arg -> {

			LOGGER.info("Start testAddSkillToEmployee");

			Employee employee = employeeService.getById(1);
			Skill skill = skillService.getById(2);
			employee.getSkillList().add(skill);
			employeeService.save(employee);

			LOGGER.info("End testAddSkillToEmployee");
		};
	}

	// sesson2 hand'son 1
	@Bean
	CommandLineRunner getAllPermanent() {
		return arg -> {

			LOGGER.info("Start getAllPermanent");

			List<Employee> all = employeeService.getAll();
			LOGGER.debug("{}", all);

			LOGGER.info("End getAllPermanent");
		};
	}

	// session 2 hand'son 4
	@Bean
	CommandLineRunner getAverageSalary() {
		return arg -> {
			LOGGER.info("Start getAverageSalary");

			double averageSalary = employeeService.getAverageSalary();
			LOGGER.debug("{}", averageSalary);

			LOGGER.info("End getAverageSalary");

		};
	}

	// session 2 hand'son 4
	@Bean
	CommandLineRunner getAverageSalaryByDept() {
		return arg -> {
			LOGGER.info("Start getAverageSalary");

			double averageSalary = employeeService.getAverageSalaryByDept(3);
			LOGGER.debug("{}", averageSalary);

			LOGGER.info("End getAverageSalary");

		};
	}

	// session 2 hand'son 5
	@Bean
	CommandLineRunner usingNative() {
		return arg -> {
			LOGGER.info("Start usingNative");

			List<Employee> allEmployeesNative = employeeService.getAllEmployeesNative();
			LOGGER.debug("{}", allEmployeesNative);

			LOGGER.info("End usingNative");

		};
	}

}
