package com.reje.dao;

import com.reje.domain.Student;

import java.util.List;

public interface StudentDao {
    int addStudent(Student student);

    List<Student> selectStudentList();

}
