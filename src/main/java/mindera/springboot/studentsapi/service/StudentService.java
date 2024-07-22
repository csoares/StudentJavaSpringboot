package mindera.springboot.studentsapi.service;

import mindera.springboot.studentsapi.entity.Student;
import mindera.springboot.studentsapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        this.studentRepository.findAll().forEach(students::add);
        return students;
    }

    public void saveOrUpdateStudent(Student student) {
        this.studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }

    public Student getStudent(Long id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("id do not exists!"));
    }
}
