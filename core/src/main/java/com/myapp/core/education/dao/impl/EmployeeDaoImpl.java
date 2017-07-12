package com.myapp.core.education.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.myapp.core.education.dao.EmployeeDao;
import com.myapp.core.user.Employee;

public class EmployeeDaoImpl implements EmployeeDao
{
	@PersistenceContext(unitName = "blPU")
	private EntityManager em;
	
	@Override
	public void save(Employee employee) 
	{
		this.em.merge(employee);
	}
	
}
