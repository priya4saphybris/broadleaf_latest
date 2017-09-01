package com.myapp.core.education.service.impl;

import java.util.List;

import com.myapp.core.education.dao.StudentDao;
import com.myapp.core.education.service.StudentService;
import com.myapp.core.user.Student;

public class DefaultStudentService implements StudentService
{
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() 
	{
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) 
	{
		this.studentDao = studentDao;
	}

	@Override
	public Student save(Student student) 
	{
		return studentDao.save(student);
	}

	@Override
	public Student getStudent(Long id) 
	{
		return studentDao.getStudent(id);
	}

	@Override
	public List<Student> getStudents() 
	{
		return studentDao.getStudents();
	}

}
