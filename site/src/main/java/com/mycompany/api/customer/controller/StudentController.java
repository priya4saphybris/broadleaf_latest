package com.mycompany.api.customer.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.core.education.beans.StudentData;
import com.myapp.core.education.facade.StudentFacade;

@Controller
@RequestMapping(value="/students")
public class StudentController 
{
	private StudentFacade studentFacade;
	
	@RequestMapping(value="/students", produces="application/json")
	public List<StudentData> getStudents()
	{
		return studentFacade.getStudents();
	}
	@RequestMapping(value="/students/{customerid}", produces="application/json")
	public List<StudentData> getStudentsForCustomer(@PathVariable("customerid") Long customerid)
	{
		if(null != customerid)
		{
			return studentFacade.getStudentsForCustomer(customerid);
		}
		return null;
	}
	
	@RequestMapping(value="/students/{customerid}", method=RequestMethod.POST, produces="application/json")
	public StudentData createStudent(StudentData studentData)
	{
		if(null != studentData)
		{
			StudentData newStudent=studentFacade.save(studentData);
			return newStudent;
		}
		return studentData;
	}
}
