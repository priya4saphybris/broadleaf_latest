package com.mycompany.api.customer.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.myapp.core.education.beans.StudentData;
import com.myapp.core.education.facade.StudentFacade;
import com.mycompany.api.data.utils.StudentDataUtil;
import com.mycompany.api.eductaion.response.StudentResponse;

@Controller
@RequestMapping(value="/student")
public class StudentController 
{
	@Resource(name="studentFacade")
	private StudentFacade studentFacade;
	
	@RequestMapping(value="/list", produces="application/json")
	public StudentResponse getStudents()
	{
		StudentResponse response= new StudentResponse();
		response.setStudents(studentFacade.getStudents());
		return response;
	}
	@RequestMapping(value="/list/{customerid}", produces="application/json")
	public StudentResponse getStudentsForCustomer(@PathVariable("customerid") Long customerid)
	{
		StudentResponse response= new StudentResponse();
		if(null != customerid)
		{
			response.setStudents(studentFacade.getStudentsForCustomer(customerid));
			return response;
		}
		
		response.setErrorMessage("Customer id shoud not be null");
		return response;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public StudentResponse createStudent(StudentData studentData)
	{
		StudentResponse response= new StudentResponse();
		if(StudentDataUtil.validate(studentData, response))
		{
			response.setStudentData(studentData);
			return response;
		}
		StudentData newStudent=studentFacade.save(studentData);
		response.setStudentData(newStudent);
		return response;
	}
}
