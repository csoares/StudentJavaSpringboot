package mindera.springboot.studentsapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDto {
    private String email;
    private String name;
    private LocalDate dateOfBirth;
}
