package project.employee_manager;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import project.employee_manager.Employee.Employee;
import project.employee_manager.Employee.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagerApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		List<Employee> employees = List
				.of(new Employee("Maria", "Silva", "Gerente", "maria.silva@email.com",
						LocalDate.of(1995, Month.JANUARY, 5)),
						new Employee("Joâo", "Souza", "Atendente", "joao.souza@email.com",
								LocalDate.of(2000, Month.MARCH, 15)));
		employeeRepository.saveAll(employees);
	}

}
