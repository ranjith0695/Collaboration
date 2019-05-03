package com.collab.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.DAO.BlogcmntDAO;
import com.collab.Model.Blogcmnt;

public class Blogcmnttesting 
{
	static BlogcmntDAO blogcmntDAO;

	@BeforeClass
	public static void executefirst()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
		blogcmntDAO=(BlogcmntDAO) context.getBean("blogcmntDAO");
	}
	
	@Ignore
	@Test
	public void addblogcmnt()
	{
		Blogcmnt blogcmnt=new Blogcmnt();
		blogcmnt.setUsername("roshan");
		blogcmnt.setCmnttext("looking forward to work withit");
		blogcmnt.setCmntdate(new java.util.Date());
		blogcmnt.setBlogid(1052);
		assertTrue("problem in adding cmnt",blogcmntDAO.addblogcmnt(blogcmnt));
	}
	
	@Ignore
	@Test
	public void deleteblogcmnt()
	{
		Blogcmnt blogcmnt=blogcmntDAO.getblogcmnt(1252);
		assertTrue("problem in deleting cmnt",blogcmntDAO.deleteblogcmnt(blogcmnt));
	}
	
	@Ignore
	@Test
	public void updateblogcmnt()
	{
		Blogcmnt blogcmnt=blogcmntDAO.getblogcmnt(1302);
		blogcmnt.setCmnttext("Nice to work with it");
		assertTrue("problem in updating",blogcmntDAO.updateblogcmnt(blogcmnt));
	}
	
	
	@Test
	public void listblogcmnts()
	{
		List<Blogcmnt> listblogcmnts=blogcmntDAO.listblogcmnts(1052);
		assertTrue("problem in listing",listblogcmnts.size()>0);
		for(Blogcmnt blogcmnt: listblogcmnts)
		{
			System.out.print(blogcmnt.getUsername()+"\t");
			System.out.print(blogcmnt.getCmnttext()+"\t");
			System.out.println(blogcmnt.getCmntdate()+"\t");
		}
	}

}
