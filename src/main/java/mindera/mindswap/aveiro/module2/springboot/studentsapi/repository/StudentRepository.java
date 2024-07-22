package mindera.mindswap.aveiro.module2.springboot.studentsapi.repository;

import mindera.mindswap.aveiro.module2.springboot.studentsapi.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {


    @Query("select s from Student s order by s.id asc")
    List<Student> findAllByOrderByIdAsc();

    @Query("select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
