package com.collab.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collab.DAO.ForumDAO;
import com.collab.Model.Forum;

@RestController
public class ForumController 
{
	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping(value="/listforums")
	public ResponseEntity<List<Forum>> listforums()
	{
		List<Forum> listforums=forumDAO.listforums();
		
		if(listforums.size()>0)
		{
			return new ResponseEntity<List<Forum>>(listforums,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listforums,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/addforum")
	public ResponseEntity<?> addforum(@RequestBody Forum forum)
	{
		forum.setCreateddate(new java.util.Date());
		
		if(forumDAO.addforum(forum))
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deleteforum/{forumid}")
	public ResponseEntity<?> deleteforum(@PathVariable("forumid") int forumid)
	{
		Forum forum=forumDAO.getforum(forumid);
		
		if(forumDAO.deleteforum(forum))
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updateforum")
	public ResponseEntity<String> updateforum(@RequestBody Forum forum)
	{
				
		if(forumDAO.updateforum(forum))
		{
			return new ResponseEntity<String>("successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getforum/{forumid}")
	public ResponseEntity<Forum> getforum(@PathVariable("forumid") int forumid)
	{
		Forum forum=forumDAO.getforum(forumid);
		
		if(forum!=null)
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
