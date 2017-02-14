package com.forum.testcase;

import com.forum.config.AppContextConfig;
import com.forum.dao.BlogDAO;
import com.forum.dao.UserDAO;
import com.forum.model.Blog;
import com.forum.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{ public static void main( String[] args )
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);
	UserDAO userDAO = (UserDAO) context.getBean("userDao");
	BlogDAO blogDAO=(BlogDAO) context.getBean("blogDao");
	Blog blog = new Blog();
	
}
   
}
