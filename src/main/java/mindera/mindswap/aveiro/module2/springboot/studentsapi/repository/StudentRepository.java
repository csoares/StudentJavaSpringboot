package mindera.mindswap.aveiro.module2.springboot.studentsapi.repository;

import mindera.mindswap.aveiro.module2.springboot.studentsapi.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
