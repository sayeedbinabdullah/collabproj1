package com.forum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.forum.model.Blog;


@Repository
@EnableTransactionManagement
@Transactional

public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	 SessionFactory sessionFactory; 

	

	public void addBlog(Blog blog)
	{
		System.out.println("i am in add blog method in daos");
		Session session=sessionFactory.openSession();
		System.out.println("session="+session);
		org.hibernate.Transaction tx = session.beginTransaction();
		//blog.setDate(data);
		session.saveOrUpdate(blog);
		tx.commit();
		System.out.println("end the add user");
		
	}
	public void updateBlog(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
		
	}

	public void deleteBlog(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(blog);
		
	}

	public Blog getBlogByBlogId(String blogId) {
		Session session=sessionFactory.getCurrentSession();
		Blog blog=null;
		try{
		blog=(Blog)session.createQuery("from Blog where blogId="+blogId).getSingleResult();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return blog;
	}

	public List<Blog> listBlogs() {
		Session session=sessionFactory.getCurrentSession();
		List<Blog> blogs=session.createQuery("from Blog").getResultList();
		
		return blogs;
	}
	
	public List<Blog> listNewBlogs() {
		Session session=sessionFactory.getCurrentSession();
		List<Blog> blogs=session.createQuery("from Blog where status='New'").getResultList();
		
		return blogs;
	}
	
	public List<Blog> listApprovedBlogs() {
		Session session=sessionFactory.getCurrentSession();
		List<Blog> blogs=session.createQuery("from Blog where status='Approved'").getResultList();
		
		return blogs;
	}

	
	public Blog getBlogByBlogId(long blogId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

	
}
