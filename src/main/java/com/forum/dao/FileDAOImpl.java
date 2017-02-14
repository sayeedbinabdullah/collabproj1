package com.forum.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.model.UploadFile;

@Repository
public class FileDAOImpl implements FileDAO{
	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void uploadFile(UploadFile file) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(file);
		session.flush();
		
	}

	
	@SuppressWarnings({ "rawtypes" })
	public UploadFile getFile(long userid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UploadFile where userid=?");
		query.setParameter(0 , userid);
		UploadFile uploadFile=(UploadFile)query.uniqueResult();
		return uploadFile;
	}

}


