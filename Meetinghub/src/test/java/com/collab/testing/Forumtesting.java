package com.collab.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.DAO.ForumDAO;
import com.collab.Model.Forum;

public class Forumtesting
{
	static ForumDAO forumDAO;
	
	 @BeforeClass
		public static void executefirst()
		{
			
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.collab");
			context.refresh();
			forumDAO=(ForumDAO) context.getBean("forumDAO");
		}
	 
	 @Ignore
	 @Test
	 public void addforum()
	 {
		 Forum forum=new Forum();
		 forum.setForumname("About jsp");
		 forum.setForumcontent("it encripts the html tags");
		 forum.setStatus("Reject");
		 forum.setUsername("ajith");
		 forum.setCreateddate(new java.util.Date());
		 assertTrue("problem in adding",forumDAO.addforum(forum));
				 
	 }
	 
	 @Ignore
	 @Test
	 public void listforums()
	 {
		 List<Forum> listforums=forumDAO.listforums();
		 assertTrue("problem in listing",listforums.size()>0);
		 for(Forum forum:listforums)
		 {
			 System.out.print(forum.getUsername()+"\t");
			 System.out.print(forum.getForumid()+"\t");
			 System.out.print(forum.getForumname()+"\t");
			 System.out.print(forum.getForumcontent()+"\t");
			 System.out.print(forum.getStatus()+"\t");
			 System.out.println(forum.getCreateddate());
		 }
	 }
	 
	 @Ignore
	 @Test
	 public void deleteforum()
	 {
		 Forum forum=forumDAO.getforum(1352);
		 assertTrue("problrm in deleting",forumDAO.deleteforum(forum));
	 }
	 
	 @Ignore
	 @Test
	 public void updateforum()
	 {
		 Forum forum=forumDAO.getforum(1452);
		 forum.setForumcontent("useful in web projects");
		 assertTrue("problrm in updating",forumDAO.updateforum(forum));
	 }
	 
	 @Ignore
	 @Test
	 public void approveforum()
	 {
		 Forum forum=forumDAO.getforum(1452);
		 assertTrue("problrm in deleting",forumDAO.approveforum(forum));
	 }
	 
	 @Ignore
	 @Test
	 public void rejectforum()
	 {
		 Forum forum=forumDAO.getforum(1452);
		 assertTrue("problrm in deleting",forumDAO.rejectforum(forum));
	 }
		
}
