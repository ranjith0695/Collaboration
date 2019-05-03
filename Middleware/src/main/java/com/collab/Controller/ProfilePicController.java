package com.collab.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.collab.DAO.ProfilePicDAO;
import com.collab.Model.ProfilePic;
import com.collab.Model.Userinfo;

@RestController
public class ProfilePicController 
{
	@Autowired
	ProfilePicDAO profilepicDAO;
	
	@RequestMapping(value="/uploadpic",method=RequestMethod.POST)
	public ResponseEntity<?> uploadpic (@RequestParam(value="file")CommonsMultipartFile fileUpload,HttpSession session)
	{
		Userinfo userinfo=(Userinfo)session.getAttribute("userinfo");
		
		if(userinfo==null)
		{
			return new ResponseEntity<String>("Unauthorized User",HttpStatus.NOT_FOUND);
		}
		
		else
		{
			ProfilePic profilepic=new ProfilePic();
			profilepic.setImage(fileUpload.getBytes());
			profilepic.setUsername(userinfo.getUsername());
			profilepicDAO.save(profilepic);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/getimage/{username}",method=RequestMethod.GET)
	public @ResponseBody byte[] getprofilepic(@PathVariable("username")String username,HttpSession session)
	{
		ProfilePic profilepic=profilepicDAO.getProfilepic(username);
		
		if(profilepic!=null)
		{
			return profilepic.getImage();
		}
		else
		{
			return null;
		}
	}

}
