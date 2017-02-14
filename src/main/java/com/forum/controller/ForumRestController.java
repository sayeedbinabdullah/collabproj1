package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.forum.dao.ForumDao;
import com.forum.model.Blog;
import com.forum.model.Forum;

@RestController
public class ForumRestController {
	
	@Autowired
	ForumDao forumdao;
	
	  //-------------------create Users--------------------------------------------------------
	 @RequestMapping(value = "/myforum", method = RequestMethod.POST)
	    public ResponseEntity<Void> addForumData(@RequestBody Forum forum,    UriComponentsBuilder ucBuilder) 
	 {
	        System.out.println("forum title " + forum.getqTitle());
	  
	        
	  
	        forumdao.addQuestion(forum);
	  
	        HttpHeaders headers = new HttpHeaders();
	      
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }

	 
	 
	 
	//-------------------Retrieve All Users--------------------------------------------------------
	    
	    @RequestMapping(value = "/myForum/", method = RequestMethod.GET)
	    public ResponseEntity<List<Forum>> listForums()
	    {
	    	System.out.println("i am in rest controller");
	        List<Forum> users = forumdao.viewQuestions();
	        System.out.println(users.toString());
	        
	        if(users.isEmpty()){
	            return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Forum>>(users, HttpStatus.OK);
	    }
	    
	  //------------------- Delete a User --------------------------------------------------------
	    
	    @RequestMapping(value = "/myforum/{qid}",headers="Accept=application/json", method = RequestMethod.DELETE)
	    public void deleteUser(@PathVariable("qid") int qid) {
	    	System.out.println("iam in blog rest delete controller");
	        
	  
	        forumdao.deleteQuestion(qid);
	       
	    }

	  //------------------- Update a User --------------------------------------------------------
	    
	    @RequestMapping(value = "/updateForum",headers="Accept=application/json", method = RequestMethod.PUT)
	    public void updateForum(@RequestBody Forum forum) {
	    	System.out.println("inside update forum");
	        
	  
	        forumdao.updateQuestion(forum);
	       
	    }
	 
}
