package mindera.springboot.studentsapi.service;

import mindera.springboot.studentsapi.dto.StudentDto;
import mindera.springboot.studentsapi.entity.Student;
import mindera.springboot.studentsapi.mapper.StudentMapper;
import mindera.springboot.studentsapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<StudentDto> getStudents() {
        List<Student> students = new ArrayList<>();
        this.studentRepository.findAll().forEach(students::add);
        return StudentMapper.INSTANCE.studentsToStudentDtos(students);
    }

    public StudentDto getStudent(Long id) {
        return StudentMapper.INSTANCE.studentToStudentDto(this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("id do not exists!")));
    }

    public Long saveStudent(StudentDto studentDto) {
        Student student = StudentMapper.INSTANCE.studentDtoToStudent(studentDto);
        this.studentRepository.save(student);
        return student.getId();
    }


    public Long updateStudent(StudentDto studentDto, Long id) {
        Student student = StudentMapper.INSTANCE.studentDtoToStudent(studentDto);
        student.setId(id);
        return this.studentRepository.save(student).getId();
    }

    public void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }

}
