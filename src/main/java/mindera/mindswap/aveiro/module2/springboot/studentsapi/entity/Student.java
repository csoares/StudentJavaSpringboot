package mindera.mindswap.aveiro.module2.springboot.studentsapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "students")
@Table
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "email", unique = true)
    public String email;
    @Column(name = "name")
    public String name;
    @Column(name = "date_of_birth")
    public LocalDate dateOfBirth;


}
