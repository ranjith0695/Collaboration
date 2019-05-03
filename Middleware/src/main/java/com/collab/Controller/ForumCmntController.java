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

import com.collab.DAO.ForumcmntDAO;
import com.collab.Model.Blogcmnt;
import com.collab.Model.Forum;
import com.collab.Model.Forumcmnt;

@RestController
public class ForumCmntController 
{
	@Autowired
	ForumcmntDAO forumcmntDAO;
	
	@GetMapping(value="/listforumcmnts/{forumid}")
	public ResponseEntity<List<Forumcmnt>> listforumcmnts(@PathVariable("forumid") int forumid)
	{
		List<Forumcmnt> listforumcmnts=forumcmntDAO.listforumcmnts(forumid);
		
		if(listforumcmnts.size()>0)
		{
			return new ResponseEntity<List<Forumcmnt>>(listforumcmnts,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forumcmnt>>(listforumcmnts,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/addforumcmnt")
	public ResponseEntity<String> addforumcmnt(@RequestBody Forumcmnt forumcmnt)
	{
		forumcmnt.setFcmntdate(new java.util.Date());
		
		if(forumcmntDAO.addforumcmnt(forumcmnt))
		{
			return new ResponseEntity<String>("successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deleteforumcmnt/{forumcmntid}")
	public ResponseEntity<String> deleteblogcmnt(@PathVariable("forumcmntid") int forumcmntid)
	{
		Forumcmnt forumcmnt=forumcmntDAO.getforumcmnt(forumcmntid);
		
		if(forumcmntDAO.deleteforumcmnt(forumcmnt))
		{
			return new ResponseEntity<String>("successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
