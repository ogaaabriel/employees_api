package project.employee_manager;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import project.employee_manager.Employee.Employee;
import project.employee_manager.Employee.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagerApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepository.save(
				new Employee("John", "Doe", "Gerente", "john.doe@email.com", LocalDate.of(2000, Month.JANUARY, 5)));
	
	}

}
