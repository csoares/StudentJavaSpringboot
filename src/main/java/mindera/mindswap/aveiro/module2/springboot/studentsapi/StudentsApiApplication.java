package mindera.mindswap.aveiro.module2.springboot.studentsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsApiApplication.class, args);
    }

//    @GetMapping
//    public String hello(){
//        return "Hello world";
//    }


//    @GetMapping
//    public List<String> hello(){
//        return List.of("hello", "world", "!");
//    }

//    @GetMapping
//    public List<Student> hello() {
//        return List.of(
//                new Student(1L, "Christophe Soares", "christophe.p.soares@mindera.com", LocalDate.of(1984, Month.MARCH, 31)),
//                new Student(2L, "Diogo Velho", "diogo.velho@mindera.com", LocalDate.of(1984, Month.MARCH, 31))
//        );
//    }

}
