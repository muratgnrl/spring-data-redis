package com.example.redis.service;

import com.example.redis.dto.StudentDto;
import com.example.redis.model.Student;
import com.example.redis.repository.StudentRepository;
import com.example.redis.response.Meta;
import com.example.redis.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse addStudent(StudentDto studentdto) {
        Student studentResult=StudentDto.fromResource(studentdto);
        studentResult=studentRepository.save(studentResult);
        return generateStudentResult(StudentDto.toResource(Optional.of(studentResult)));
    }

    private StudentResponse generateStudentResult(StudentDto fromDto) {
        StudentResponse studenResponse=new StudentResponse();
        Meta meta=new Meta();
        studenResponse.meta=new Meta(200,"Ogrenci kayıt başarılı");
        studenResponse.student=fromDto;
        return studenResponse;
    }


    public ResponseEntity<StudentDto> findStudent(int studentId) {
        Optional<Student> student=studentRepository.findById(studentId);
        StudentResponse studentResponse  =new StudentResponse();
        return ResponseEntity.ok(StudentDto.toResource(student));
    }

    public Boolean deleteStudent(int studentId){

        Optional<Student> student=studentRepository.findById(studentId);
        if (student!=null){

            studentRepository.deleteById(studentId);
            return true;
        }else {

            return false;
        }

    }

    public Student updateStudent(int studentId, Student student) {

        Optional<Student> studentResult=studentRepository.findById(studentId);
        if (student!=null){
            studentResult.get().setName(student.getName());
            studentResult.get().setSurname(student.getSurname());
            studentResult.get().setPhoneNumber(student.getPhoneNumber());


            return studentRepository.save(studentResult.get());
        }
        return null;
    }
}
