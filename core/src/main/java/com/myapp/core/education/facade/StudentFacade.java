package com.myapp.core.education.facade;

import java.util.List;

import com.myapp.core.education.beans.StudentData;

public interface StudentFacade
{
	StudentData save(StudentData student);
	StudentData getStudent(Long id);
	List<StudentData> getStudentsForCustomer(Long id);
	List<StudentData> getStudents();
}
