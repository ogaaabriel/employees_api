package project.employee_manager.Employee;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private LocalDate birthDate;

    public Employee(String firstName, String lastName, String position, String email, LocalDate birthDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setPosition(position);
        setEmail(email);
        setBirthDate(birthDate);
    }

}
