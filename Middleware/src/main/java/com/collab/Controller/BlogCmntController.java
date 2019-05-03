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

import com.collab.DAO.BlogcmntDAO;
import com.collab.Model.Blogcmnt;

@RestController
public class BlogCmntController 
{
	@Autowired
	BlogcmntDAO blogcmntDAO;
	
	@GetMapping(value="/listblogcmnts/{blogid}")
	public ResponseEntity<List<Blogcmnt>> listblogcmnt(@PathVariable("blogid") int blogid)
	{
		List<Blogcmnt> listblogcmnts=blogcmntDAO.listblogcmnts(blogid);
		
		if(listblogcmnts.size()>0)
		{
			return new ResponseEntity<List<Blogcmnt>>(listblogcmnts,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blogcmnt>>(listblogcmnts,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/addblogcmnt")
	public ResponseEntity<?> addblogcmnt(@RequestBody Blogcmnt blogcmnt)
	{
          blogcmnt.setCmntdate(new java.util.Date());
		
		if(blogcmntDAO.addblogcmnt(blogcmnt))
		{
			return new ResponseEntity<Blogcmnt>(blogcmnt,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deleteblogcmnt/{cmntid}")
	public ResponseEntity<?> deleteblogcmnt(@PathVariable("cmntid") int cmntid)
	{
		Blogcmnt blogcmnt=blogcmntDAO.getblogcmnt(cmntid);
		
		if(blogcmntDAO.deleteblogcmnt(blogcmnt))
		{
			return new ResponseEntity<Blogcmnt>(blogcmnt,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updateblogcmnt")
	public ResponseEntity<String> updateblogcmnt(@RequestBody Blogcmnt blogcmnt)
	{
		if(blogcmntDAO.updateblogcmnt(blogcmnt))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/getblogcmnt/{cmntid}")
	public ResponseEntity<Blogcmnt> getblogcmnt(@PathVariable("cmntid") int cmntid)
	{
		Blogcmnt blogcmnt=blogcmntDAO.getblogcmnt(cmntid);
		
		if(blogcmnt!=null)
		{
			return new ResponseEntity<Blogcmnt>(blogcmnt,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Blogcmnt>(blogcmnt,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
