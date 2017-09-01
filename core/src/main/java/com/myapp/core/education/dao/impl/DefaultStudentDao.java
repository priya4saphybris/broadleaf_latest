package com.myapp.core.education.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.myapp.core.education.dao.StudentDao;
import com.myapp.core.user.Student;

public class DefaultStudentDao implements StudentDao
{
	@PersistenceContext(unitName = "blPU")
	private EntityManager em;
	
	@Override
	public Student save(Student student) 
	{
		return em.merge(student);
	}

	@Override
	public Student getStudent(Long id) 
	{
		return em.find(Student.class, id);
	}

	@Override
	public List<Student> getStudents() 
	{
		TypedQuery<Student> query = this.em.createQuery("FROM "+com.myapp.core.user.Student.class.getName(), Student.class);
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		query.setHint("org.hibernate.cacheRegion", "blStandardElements");
		return query.getResultList();
	}

}
