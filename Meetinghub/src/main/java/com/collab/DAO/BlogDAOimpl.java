package com.collab.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.Model.Blog;
@Repository("blogDAO")
@Transactional
public class BlogDAOimpl implements BlogDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addblog(Blog blog) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public boolean deleteblog(Blog blog) 
	{
		try
		{
			sessionfactory.getCurrentSession().remove(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public boolean updateblog(Blog blog) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public List<Blog> listblogs() 
	{

		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> listblogs=query.list();
		session.close();
		return listblogs;
	}

	@Override
	public Blog getblog(int blogid) 
	{
		Session session=sessionfactory.openSession();
		Blog blog=session.get(Blog.class, blogid);
		session.close();
		return blog;
	}

	@Override
	public boolean incrementlikes(Blog blog) 
	{
		try
		{
			blog.setLikes(blog.getLikes()+1);
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public boolean incrementdislikes(Blog blog) 
	{
		try
		{
			blog.setDislikes(blog.getDislikes()+1);
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public boolean approveblog(Blog blog) 
	{
		try
		{
			blog.setStatus("Approve");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public boolean rejectblog(Blog blog) 
	{
		try
		{
			blog.setStatus("NotApprove");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

}
