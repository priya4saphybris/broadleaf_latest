package com.myapp.core.education.dao;

import java.util.List;

import com.myapp.core.user.Student;

public interface StudentDao 
{
	Student save(Student student);
	Student getStudent(Long id);
	List<Student> getStudents();
}
