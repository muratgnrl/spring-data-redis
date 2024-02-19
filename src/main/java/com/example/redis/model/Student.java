package com.example.redis.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.data.redis.core.RedisHash;



@RedisHash("ögrenci")
public class Student  {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int studentId;

        private String name;


        private String surname;

        private String phoneNumber;


        private String birthDay;
        public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Student() {
    }

    public Student(int studentId, String name, String surname, String phoneNumber, String birthDay) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;

    }
}