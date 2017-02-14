package com.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.forum.model.Blog;
import com.forum.model.Forum;

@Repository("forumDao")
@EnableTransactionManagement
@Transactional
public class ForumDaoImpl implements ForumDao {
	
	@Autowired
	SessionFactory sessionFactory;

	
	public void addQuestion(Forum forum) 
	{
		Session session =sessionFactory.getCurrentSession();
		System.out.println("session"+session);
		session.saveOrUpdate(forum);
		System.out.println("data successfully saved");
	}

	
	public List<Forum> viewQuestions() {
		
		Session session=sessionFactory.getCurrentSession();
		// TODO Auto-generated method stub
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Forum> list = session.createCriteria(Forum.class).list();
		return list;
	}
	
	


	public void updateQuestion(Forum forum) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(forum);
		
		
	}


	public void deleteQuestion(int qid) {
		Session session=sessionFactory.getCurrentSession();
		Forum forum=(Forum)session.get(Forum.class, new Integer(qid));
		session.delete(forum);
		
	}


	public Forum getQuestion(int qid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
