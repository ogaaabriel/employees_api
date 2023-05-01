package project.employee_manager.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.Map;

@RestController()
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public Iterable<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
            @Valid @RequestBody EmployeeUpdateDto employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Empregado excluído com sucesso"));
    }

}
