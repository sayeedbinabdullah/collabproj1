package com.forum.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.forum.dao.BlogDAO;
import com.forum.dao.JobRegistrationDAO;
import com.forum.model.Jobs;
import com.forum.model.JobRegistration;
import com.forum.model.User;

@RestController
public class JobRegistrationController {
	
	@Autowired
	JobRegistrationDAO jobrdao;
	
	//-------------------Create a Blog--------------------------------------------------------
	@RequestMapping(value="/jobr", method=RequestMethod.POST)
	
    public ResponseEntity<Void> createBlog(@RequestBody JobRegistration jobr,HttpSession session) {
		User currentUser =  (User)session.getAttribute("user");
		//currentUser.setUserid(session.getAttribute(arg0));
        jobr.setUser(currentUser);
        
        Jobs job=(Jobs)session.getAttribute("jobid");
        
        jobr.setJobid(job);
        jobrdao.addJobr(jobr);
  
       
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
