package com.myapp.core.education.facade.impl;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.service.CustomerService;

import com.myapp.core.converter.Converter;
import com.myapp.core.education.beans.StudentData;
import com.myapp.core.education.facade.StudentFacade;
import com.myapp.core.education.service.StudentService;
import com.myapp.core.user.Student;

public class DefaultStudentFacade implements StudentFacade
{
	private StudentService studentService;
	
	private Converter<Student, StudentData> studentConverter;
	
	private CustomerService customerService;
	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Converter<Student, StudentData> getStudentConverter() {
		return studentConverter;
	}

	public void setStudentConverter(Converter<Student, StudentData> studentConverter) {
		this.studentConverter = studentConverter;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public StudentData save(StudentData studentData) 
	{
		Student student= new Student();
		if(null != studentData.getCustomerid())
		{
			Customer customer=customerService.readCustomerById(studentData.getId());
			student.setCustomer(customer);
		}
		
		student=studentService.save(student);
		return studentConverter.convert(student);
	}

	@Override
	public StudentData getStudent(Long id) 
	{
		return studentConverter.convert(studentService.getStudent(id));
	}

	@Override
	public List<StudentData> getStudents() 
	{
		List<Student> students= studentService.getStudents();
		return studentConverter.convertAll(students);
	}

	@Override
	public List<StudentData> getStudentsForCustomer(Long id) 
	{
		List<Student> students= studentService.getStudentsForCustomer(id);
		return studentConverter.convertAll(students);
	}

}
