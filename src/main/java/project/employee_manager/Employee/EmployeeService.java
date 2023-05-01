package project.employee_manager.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import project.employee_manager.Exception.BadRequestException;
import project.employee_manager.Exception.NotFoundException;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> findAll(int page, int size, String position) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "firstName", "lastName"));

        Specification<Employee> spec = Specification.where(null);
        if (position != null && !position.isBlank()) {
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("position"),
                            "%" + position + "%"));
        }

        return employeeRepository.findAll(spec, pageable);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Empregado não encontrado"));
    }

    public Employee save(Employee employee) {
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new BadRequestException("Email já cadastrado");
        }
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, EmployeeUpdateDto employee) {
        Employee employeeDB = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empregado não encontrado"));

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new BadRequestException("Email já cadastrado");
        }

        if (employee.getFirstName() != null) {
            employeeDB.setFirstName(employee.getFirstName());
        }

        if (employee.getLastName() != null) {
            employeeDB.setLastName(employee.getLastName());
        }

        if (employee.getPosition() != null) {
            employeeDB.setPosition(employee.getPosition());
        }

        if (employee.getEmail() != null) {
            employeeDB.setEmail(employee.getEmail());
        }

        if (employee.getBirthDate() != null) {
            employeeDB.setBirthDate(employee.getBirthDate());
        }

        return employeeRepository.save(employeeDB);
    }

    public void delete(Long id) {
        Employee employeeDB = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empregado não encontrado"));
        employeeRepository.delete(employeeDB);
    }

}