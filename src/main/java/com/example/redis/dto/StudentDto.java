package com.example.redis.dto;

import com.example.redis.model.Student;

import java.util.Optional;

public class StudentDto {
    public int studentId;
    public String name;
    public String surname;
    public String phoneNumber;
    public String birthDay;


    public static Student fromResource(StudentDto studentDto){
        Student student = new Student();
        student.setStudentId(studentDto.studentId);
        student.setName(studentDto.name);
        student.setSurname(studentDto.surname);
        student.setBirthDay(studentDto.birthDay);
        student.setPhoneNumber(studentDto.phoneNumber);
        return student;
    }
    public static StudentDto toResource(Optional<Student> student){
        StudentDto studentDto = new StudentDto();
        studentDto.birthDay=student.get().getBirthDay();
        studentDto.name = student.get().getName();
        studentDto.surname = student.get().getSurname();
        studentDto.phoneNumber = student.get().getPhoneNumber();
        studentDto.studentId = student.get().getStudentId();
        return studentDto;
    }

}