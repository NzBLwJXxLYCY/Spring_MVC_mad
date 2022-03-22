package com.reje.service;

import com.reje.domain.Student;

import java.util.List;

public interface StudentService {
    int AddStudent(Student student);

    List<Student> FindStudent();
}
