package com.example.redis.response;

import com.example.redis.dto.StudentDto;

import java.io.Serializable;

public class StudentResponse extends BaseResponse implements Serializable {
    public StudentDto student;
}
