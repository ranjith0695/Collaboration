package com.collab.testing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.DAO.UserDAO;
import com.collab.Model.Userinfo;

public class Usertest
{
	static UserDAO userDAO;

	@BeforeClass
	public static void executefirst()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	
    @Ignore
	@Test
	public void registeruser()
	{
		Userinfo user=new Userinfo();
		user.setCustomername("rahul ghandhi");
		user.setEmailid("rahul66@gmail.com");
		user.setUsername("rahul666");
		user.setPassword("rahul321");
		user.setMobileno("9444563412");
		user.setRole("student");
		user.setStatus("Approve");
		user.setIsonline("On");
		
		assertTrue("problem in registering user",userDAO.registeruser(user));
	}
	
	
	@Test
	public void updateuser()
	{
		Userinfo user=userDAO.getuser("ranjith");
		user.setRole("Admin");
		assertTrue("problem in updating user",userDAO.updateuser(user));
	}
	
	@Ignore
	@Test
	public void approveuser()
	{
		Userinfo user=userDAO.getuser("rahul");
		assertTrue("problem in approviing user",userDAO.approveuser(user));
	}
	
	@Ignore
	@Test
	public void rejectuser()
	{
		Userinfo user=userDAO.getuser("rahul");
		assertTrue("problem in rejecting user",userDAO.rejectuser(user));
	}
	
	@Ignore
	@Test
	public void makeoffline()
	{
		Userinfo user=userDAO.getuser("rahul");
		assertTrue("problem in making offline user",userDAO.makeoffline(user));
	}
	
	@Ignore
	@Test
	public void makeonline()
	{
		Userinfo user=userDAO.getuser("rahul");
		assertTrue("problem in updating user",userDAO.makeonline(user));
	}

}
