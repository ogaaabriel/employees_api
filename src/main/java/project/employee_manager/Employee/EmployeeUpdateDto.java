package project.employee_manager.Employee;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class EmployeeUpdateDto {

    private String firstName;
    private String lastName;
    private String position;
    @Email(message = "Email inválido")
    private String email;
    @Past(message = "Data de nascimento deve ser anterior a data atual")
    private LocalDate birthDate;

}
