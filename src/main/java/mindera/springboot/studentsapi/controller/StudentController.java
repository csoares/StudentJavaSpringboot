package mindera.springboot.studentsapi.controller;

import mindera.springboot.studentsapi.dto.StudentDto;
import mindera.springboot.studentsapi.dto.StudentUpdateDto;
import mindera.springboot.studentsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Object> updateStudent(@PathVariable("StudentID") Long id, @Valid @RequestBody StudentUpdateDto studentUpdateDtoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        studentService.updateStudent(studentUpdateDtoDto, id);
        return null;
    }
}
