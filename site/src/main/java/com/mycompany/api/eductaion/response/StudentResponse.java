package com.mycompany.api.eductaion.response;

import java.util.List;

import com.myapp.core.education.beans.StudentData;

public class StudentResponse 
{
	private String errorMessage;
	private StudentData studentData;
	private List<StudentData> students;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public StudentData getStudentData() {
		return studentData;
	}
	public void setStudentData(StudentData studentData) {
		this.studentData = studentData;
	}
	public List<StudentData> getStudents() {
		return students;
	}
	public void setStudents(List<StudentData> students) {
		this.students = students;
	}
	
}
