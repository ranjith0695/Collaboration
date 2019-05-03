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

import com.collab.DAO.BlogDAO;
import com.collab.Model.Blog;

@RestController
public class BlogController 
{
	@Autowired
	BlogDAO blogDAO;
	
	@GetMapping(value="/listblogs")
	public ResponseEntity<List<Blog>> listblogs()
	{
		List<Blog> listblogs=blogDAO.listblogs();
		
		if(listblogs.size()>0)
		{
			return new ResponseEntity<List<Blog>>(listblogs,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(listblogs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/addblog")
	public ResponseEntity<?> addblog(@RequestBody Blog blog)
	{
		blog.setCreateddate(new java.util.Date());
		
		if(blogDAO.addblog(blog))
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deleteblog/{blogid}")
	public ResponseEntity<?> deleteblog(@PathVariable("blogid") int blogid)
	{
		Blog blog=blogDAO.getblog(blogid);
		
		if(blogDAO.deleteblog(blog))
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updateblog")
	public ResponseEntity<?> updateblog(@RequestBody Blog blog)
	{
		if(blogDAO.updateblog(blog))
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/incrementlikes/{blogid}")
	public ResponseEntity<String> incrementlikes(@PathVariable("blogid") int blogid)
	{
		Blog blog=blogDAO.getblog(blogid);
		
		if(blogDAO.incrementlikes(blog))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/incrementdislikes/{blogid}")
	public ResponseEntity<String> incrementdislikes(@PathVariable("blogid") int blogid)
	{
		Blog blog=blogDAO.getblog(blogid);
		
		if(blogDAO.incrementdislikes(blog))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/approveblog/{blogid}")
	public ResponseEntity<String> approveblog(@PathVariable("blogid") int blogid)
	{
		Blog blog=blogDAO.getblog(blogid);
		
		if(blogDAO.approveblog(blog))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/rejectblog/{blogid}")
	public ResponseEntity<String> rejectblog(@PathVariable("blogid") int blogid)
	{
		Blog blog=blogDAO.getblog(blogid);
		
		if(blogDAO.rejectblog(blog))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getblog/{blogid}")
	public ResponseEntity<Blog> getblog(@PathVariable("blogid") int blogid)
	{
		Blog blog=blogDAO.getblog(blogid);
		
		if(blog!=null)
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
