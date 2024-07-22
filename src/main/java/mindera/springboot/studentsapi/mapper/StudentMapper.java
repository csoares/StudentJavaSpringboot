package mindera.springboot.studentsapi.mapper;

import mindera.springboot.studentsapi.dto.StudentDto;
import mindera.springboot.studentsapi.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student studentDtoToStudent(StudentDto studentDto);

    StudentDto studentToStudentDto(Student student);

    List<StudentDto> studentsToStudentDtos(List<Student> students);

    List<Student> studentDtosToStudents(List<StudentDto> studentDtos);
}
