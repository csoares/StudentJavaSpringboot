package mindera.springboot.studentsapi.controller;

import mindera.springboot.studentsapi.entity.Student;
import mindera.springboot.studentsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @GetMapping(path = "{StudentID}")
    public Student getStudent(@PathVariable("StudentID") Long id) {
        return this.studentService.getStudent(id);
    }

    @PostMapping
    public Long addNewStudent(@RequestBody Student student) {
        this.studentService.saveOrUpdateStudent(student);
        return student.getId();
    }

    @DeleteMapping(path = "{StudentID}")
    public void deleteStudent(@PathVariable("StudentID") Long id) {
        this.studentService.deleteStudent(id);
    }

    @PutMapping(path = "{StudentID}")
    public Student updateStudent(@PathVariable("StudentID") Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.saveOrUpdateStudent(student);
        return student;
    }
}
