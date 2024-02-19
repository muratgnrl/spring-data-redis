package com.example.redis.control;

import com.example.redis.dto.StudentDto;
import com.example.redis.model.Student;
import com.example.redis.response.StudentResponse;
import com.example.redis.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class StudentControl {

    private final StudentService studentService;

    public StudentControl(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public StudentResponse addStudent(@RequestBody StudentDto studentdto){
        return studentService.addStudent(studentdto);
    }
    @GetMapping("/find/{studentId}")
    public ResponseEntity<StudentDto> findStudent(@PathVariable int studentId){
        return (studentService.findStudent(studentId));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable int studentId){
        Boolean delete=studentService.deleteStudent(studentId);
        return ResponseEntity.ok(delete);


    }
    @PutMapping("edit/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable (name = "studentId") int studentId ,@RequestBody Student student){
        Student result=studentService.updateStudent(studentId,student);
        return ResponseEntity.ok(result);
    }
}
