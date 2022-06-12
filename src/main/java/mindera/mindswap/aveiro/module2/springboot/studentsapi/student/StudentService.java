package mindera.mindswap.aveiro.module2.springboot.studentsapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
//        return List.of(
//                new Student(1L, "Christophe Soares", "christophe.p.soares@mindera.com", LocalDate.of(1984, Month.MARCH, 31)),
//                new Student(2L, "Diogo Velho", "diogo.velho@mindera.com", LocalDate.of(1984, Month.MARCH, 31))
//        );
//        return this.studentRepository.findAll();
        return this.studentRepository.findAllByOrderByIdAsc();
    }

    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent = this.studentRepository.findStudentByEmail(student.getEmail());
        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("email is already used!");
        }
        this.studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        System.out.println("id = " + id);
        if (!this.studentRepository.existsById(id)) {
            throw new IllegalStateException("id do not exists!");
        }
        this.studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, Student studentValues) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("student do not exist"));

        if (studentValues.getName() != null && studentValues.getName().length() > 0 && !student.getName().equals(studentValues.getName())) {
            student.setName(studentValues.getName());
            System.out.println("here - update name");
        }

        if (studentValues.getEmail() != null && studentValues.getEmail().length() > 0 && !student.getEmail().equals(studentValues.getEmail())) {
            student.setEmail(studentValues.getEmail());
            System.out.println("here - update email");
        }

    }
}
