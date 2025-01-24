package mindera.springboot.studentsapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class StudentUpdateDto {
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Must have your name")
    private String name;
    @DateTimeFormat
    private LocalDate dateOfBirth;
}
