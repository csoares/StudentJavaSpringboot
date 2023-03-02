package mindera.mindswap.aveiro.module2.springboot.studentsapi.controller;

import mindera.mindswap.aveiro.module2.springboot.studentsapi.entity.Student;
import mindera.mindswap.aveiro.module2.springboot.studentsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> hello() {
        return this.studentService.getStudent();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        this.studentService.addNewStudent(student);
    }

    // http://localhost:8080/api/v1/student/2
    @DeleteMapping(path = "{StudentID}")
    public void deleteStudent(@PathVariable("StudentID") Long id) {
        this.studentService.deleteStudent(id);
    }


    @PutMapping(path = "{studentID}")
    public void updateStudent(@PathVariable("studentID") Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }
}
