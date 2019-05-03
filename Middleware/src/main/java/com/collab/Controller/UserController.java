package com.collab.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collab.DAO.UserDAO;
import com.collab.Model.Userinfo;

@RestController
public class UserController 
{
	@Autowired
	UserDAO userDAO;
	
	@PostMapping(value="/registeruser")
	public ResponseEntity<?> registeruser(@RequestBody Userinfo user)
	{
		if(userDAO.registeruser(user))
		{
			return new ResponseEntity<Userinfo>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/approveuser/{username}")
	public ResponseEntity<String> approveuser(@PathVariable("username") String username)
	{
		Userinfo user=userDAO.getuser(username);
		
		if(userDAO.approveuser(user))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/rejectuser/{username}")
	public ResponseEntity<String> rejectuser(@PathVariable("username") String username)
	{
		Userinfo user=userDAO.getuser(username);
		
		if(userDAO.rejectuser(user))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value="/updateuser")
	public ResponseEntity<String> updateuser(@RequestBody Userinfo user)
	{
		if(userDAO.updateuser(user))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	
	@PostMapping(value="/checklogin")
	public ResponseEntity<Userinfo> checklogin(@RequestBody Userinfo user,HttpSession session)
	{
		Userinfo tempuser=userDAO.getuser(user.getUsername());
		 if(tempuser!=null)
		 {
			 if(tempuser.getPassword().equals(user.getPassword()) && tempuser.getStatus().equals("Approve"))
			    {
				    session.setAttribute("userinfo", tempuser);
				    
					return new ResponseEntity<Userinfo>(tempuser,HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<Userinfo>(tempuser,HttpStatus.INTERNAL_SERVER_ERROR);
				}
		 }
		 else
		 {
			 return new ResponseEntity<Userinfo>(tempuser,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}

}
