package com.forum.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.forum.dao.UserDAO;
import com.forum.dao.FileDAO;
import com.forum.model.User;
import com.forum.model.UploadFile;

@RestController
public class UserRestController {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	FileDAO fileUploadDao;
	
	//retrieve all users
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> getAllUsers()
	{
		return userDAO.listUsers();
	}
	
	//retrive a specific user
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public User getUser(@PathVariable("userId") long userId)
	{
		return userDAO.getUserById(userId);
	}
	
	
	//create a new user
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public void createUser(@RequestBody User user)
	{
		userDAO.addUser(user);
	}
	
	
	//update an existing user
		@RequestMapping(value="/user/{userId}",method=RequestMethod.PUT)
		public void updateUser(@RequestBody User user,@PathVariable("userId") long userId)
		{
			User u=userDAO.getUserById(userId);
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			u.setCity(user.getCity());
			u.setMobile(user.getMobile());
			u.setRole(user.getRole());
			
			userDAO.updateUser(u);
		}
	
	
	
	//delete an existing user
	@RequestMapping(value="/user/{userId}",method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") long userId)
	{
		userDAO.deleteUser(userDAO.getUserById(userId));
	}
	
	@RequestMapping(value="/logincheck", method=RequestMethod.POST)
	public ResponseEntity <?> logincheck(@RequestBody User user,HttpSession session){
		System.out.println("Entering UserController : Login()");
		long userId=user.getUserId();
		User validuser = userDAO.logincheck(user);
		System.out.println("\n" + user.getUserId());
		
		if(validuser==null){
			System.out.println("validuser is null");
			Error error = new Error("User does not exists");
			return new ResponseEntity<Error> (error,HttpStatus.UNAUTHORIZED);// 401
		}
		else{
			session.setAttribute("user", validuser);
			validuser.setIsonline(true);
			userDAO.updateUser(validuser); // - to be uncommented after 
			System.out.print("\nlogincheck - " + validuser.getRole()); 
			System.out.println("valid user is available");
			
			 //select * from proj2_profile_pics where username='adam';
			  UploadFile getUploadFile=fileUploadDao.getFile(validuser.getUserId());
			  if(getUploadFile!=null){
		  	//String name=getUploadFile.getFilename();
		  	System.out.println(getUploadFile.getData());
		  	byte[] imagefiles=getUploadFile.getData();
		  	try{
		  		
		  		String path="C:/Users/sayeed/Second Project/CollaborationBackend/src/main/webapp/resources/images/users/"+validuser.getUserId()+".jpg";
		  		File file=new File(path);
		  		//file.mkdirs();
		  		FileOutputStream fos = new FileOutputStream(file);//to Write some data 
		  		fos.write(imagefiles);
		  		fos.close();
		  		}catch(Exception e){
		  		e.printStackTrace();
		  		}
			  }
			
			
			return new  ResponseEntity<User> (validuser, HttpStatus.OK);
		}		
	}

	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session){
		User ud = (User)session.getAttribute("user");
		if(ud!=null){
			ud.setIsonline(false);
			userDAO.updateUser(ud);
			try{
                //change according to your workspace path and project name
				String path="C:/Users/sayeed/Second Project/CollaborationBackend/src/main/webapp/resources/images/users/"+ud.getUserId()+".jpg";
				File file=new File(path);
				System.out.println(file.delete());
		
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		session.removeAttribute("user");		
		session.invalidate();
		return new  ResponseEntity<Void> (HttpStatus.OK);		
		
	}

}
