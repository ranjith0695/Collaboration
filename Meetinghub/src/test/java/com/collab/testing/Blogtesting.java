package com.collab.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.DAO.BlogDAO;
import com.collab.Model.Blog;

public class Blogtesting
{
	static BlogDAO blogDAO;

    @BeforeClass
	public static void executefirst()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
		blogDAO=(BlogDAO) context.getBean("blogDAO");
	}
    
    @Ignore
    @Test
    public void addblog()
    {
    	Blog blog=new Blog();
    	blog.setBlogname("servlet");
    	blog.setBlogcontent("server based programming");
    	blog.setCreateddate(new java.util.Date());
    	blog.setDislikes(0);
    	blog.setLikes(0);
    	blog.setStatus("NotApprove");
    	blog.setUsername("roshan");
    	assertTrue("problem in adding blog",blogDAO.addblog(blog));

    }
    
    @Ignore
    @Test
    public void deleteblog()
    {
    	Blog blog=blogDAO.getblog(1002);
    	assertTrue("problem in deleting blog",blogDAO.deleteblog(blog));
    }
    @Ignore
    @Test
    public void updateblog()
    {
    	Blog blog=blogDAO.getblog(1052);
    	blog.setBlogcontent("A application to create a web page");
    	blog.setBlogname("jsp");
    	assertTrue("problem in updating blog",blogDAO.updateblog(blog));
    }
    
    @Ignore
    @Test
    public void listblogs()
    {
    	List<Blog> listblogs=blogDAO.listblogs();
    	assertTrue("problem in listing blog",listblogs.size()>0);
    	for(Blog blog:listblogs)
    	{
    		System.out.print(blog.getBlogid()+"\t");
    		System.out.print(blog.getBlogname()+"\t");
    		System.out.print(blog.getBlogcontent()+"\t");
    		System.out.println(blog.getUsername());   		
    		
    	}
    }
    
    @Ignore
    @Test
    public void incrementlikes()
    {
    	Blog blog=blogDAO.getblog(1052);
    	assertTrue("problem in incrementinglikes",blogDAO.incrementlikes(blog));
    	
    }
    
    @Ignore
    @Test
    public void incrementdislikes()
    {
    	Blog blog=blogDAO.getblog(1052);
    	assertTrue("problem in incrementingdislikes",blogDAO.incrementdislikes(blog));
    	
    }
    
    @Ignore
    @Test
    public void approveblog()
    {
    	Blog blog=blogDAO.getblog(1052);
    	
    	assertTrue("problem in Approvingblog",blogDAO.approveblog(blog));
    	
    }
    
    @Ignore
    @Test
    public void rejectblog()
    {
    	Blog blog=blogDAO.getblog(1052);
    	
    	assertTrue("problem in rejectingblog",blogDAO.rejectblog(blog));
    	
    }


}
