package mindera.springboot.studentsapi.controller;

import mindera.springboot.studentsapi.dto.StudentDto;
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
    public List<StudentDto> getStudent() {
        return this.studentService.getStudents();
    }

    @GetMapping(path = "{StudentID}")
    public StudentDto getStudents(@PathVariable("StudentID") Long id) {
        return this.studentService.getStudent(id);
    }

    @PostMapping
    public Long addNewStudent(@RequestBody StudentDto studentDto) {
        return this.studentService.saveStudent(studentDto);
    }

    @DeleteMapping(path = "{StudentID}")
    public void deleteStudent(@PathVariable("StudentID") Long id) {
        this.studentService.deleteStudent(id);
    }

    @PutMapping(path = "{StudentID}")
    public StudentDto updateStudent(@PathVariable("StudentID") Long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto, id);
        return studentDto;
    }
}
