package com.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.model.JobRegistration;
import com.forum.model.Jobs;


@Repository
@Transactional
public class JobsDaoImpl  implements JobsDao{
	
	@Autowired
	SessionFactory sessionFactory;

	
	public void addJob(Jobs job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	
	public List<Jobs> viewJobs() {
		Session session=sessionFactory.getCurrentSession();
		return session.createCriteria(Jobs.class).list();
	}
	
	

	
	public void deleteJob(int id) {
		Session session=sessionFactory.getCurrentSession();
		Jobs job=(Jobs) session.get(Jobs.class, new Integer(id));
		session.delete(job);
	}

	
	public void updateJob(Jobs job) {
		Session session=sessionFactory.getCurrentSession();
		session.update(job);
		
	}

	
	public Jobs viewJob(int id) {
		Session session=sessionFactory.getCurrentSession();
		Jobs job=(Jobs) session.get(Jobs.class, new Integer(id));
		return job;
	}

	
	public void registerJob(JobRegistration jobregistration) {
		Session session=sessionFactory.getCurrentSession();
		session.save(jobregistration);
	}

}
