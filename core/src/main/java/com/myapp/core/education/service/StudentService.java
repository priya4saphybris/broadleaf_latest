package com.myapp.core.education.service;

import java.util.List;

import com.myapp.core.user.Student;

public interface StudentService 
{
	Student save(Student student);
	Student getStudent(Long id);
	List<Student> getStudents();
}
