package com.forum.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.forum.model.JobRegistration;

@Repository
@EnableTransactionManagement
@Transactional

public class JobRegistrationDAOImpl implements JobRegistrationDAO {
	
	@Autowired
	 SessionFactory sessionFactory; 


	
	public void addJobr(JobRegistration jobr) {
		
		System.out.println("Jobr dao impl" +  jobr);
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(jobr);
		
	}
		
		
	}


