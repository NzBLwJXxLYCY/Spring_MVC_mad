package com.reje.service.Impl;

import com.reje.dao.StudentDao;
import com.reje.domain.Student;
import com.reje.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public int AddStudent(Student student) {
        int nums =studentDao.addStudent(student);
        return nums;
    }

    @Override
    public List<Student> FindStudent() {
        List<Student> students = studentDao.selectStudentList();
        return students;
    }
}
