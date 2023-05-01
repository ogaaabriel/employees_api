package project.employee_manager.Employee;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Nome não pode ser nulo")
    private String firstName;
    @NotBlank(message = "Sobrenome não pode ser nulo")
    private String lastName;
    @NotBlank(message = "Cargo não pode ser nulo")
    private String position;
    @NotBlank(message = "Email não pode ser nulo")
    @Email(message = "Email inválido")
    private String email;
    @NotNull(message = "Data de nascimento não pode ser nula")
    @Past(message = "Data de nascimento deve ser anterior a data atual")
    private LocalDate birthDate;

    public Employee(String firstName, String lastName, String position, String email, LocalDate birthDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setPosition(position);
        setEmail(email);
        setBirthDate(birthDate);
    }

}
