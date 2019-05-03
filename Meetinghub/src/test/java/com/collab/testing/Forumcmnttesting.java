package com.collab.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.DAO.ForumcmntDAO;
import com.collab.Model.Forumcmnt;

public class Forumcmnttesting 
{

	static ForumcmntDAO forumcmntDAO;
	
	@BeforeClass
	public static void executefirst()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
		forumcmntDAO=(ForumcmntDAO) context.getBean("forumcmntDAO");
	}
	
	@Ignore
	@Test 
	public void addfroumcmnt()
	{
		Forumcmnt forumcmnt=new Forumcmnt();
		forumcmnt.setForumid(1452);
		forumcmnt.setFcmnt("interesting to learn");
		forumcmnt.setFcmntdate(new java.util.Date());
		forumcmnt.setUsername("ajith");
		assertTrue("problem in adding forumcmnt",forumcmntDAO.addforumcmnt(forumcmnt));
	}
	
	@Ignore
	@Test
	public void deleteforumcmnt()
	{
		Forumcmnt forumcmnt=forumcmntDAO.getforumcmnt(1502);
		assertTrue("problem in deleting forumcmnt",forumcmntDAO.deleteforumcmnt(forumcmnt));
	}
	
	@Ignore
	@Test
	public void listforumcmnts()
	{
		List<Forumcmnt> listforumcmnts=forumcmntDAO.listforumcmnts(1452);
		assertTrue("problem in listing",listforumcmnts.size()>0);
		for(Forumcmnt forumcmnt:listforumcmnts)
		{
			System.out.print(forumcmnt.getForumcmntid()+"\t");
			System.out.print(forumcmnt.getFcmnt()+"\t");
			System.out.print(forumcmnt.getUsername()+"\t");
			System.out.print(forumcmnt.getFcmntdate()+"\t");
		}
	}

}
