package com.collab.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.Model.Forum;
@Repository("forumDAO")
@Transactional
public class ForumDAOimpl implements ForumDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addforum(Forum forum) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised: "+e);
			return false;
		}
	}

	@Override
	public boolean deleteforum(Forum forum) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised: "+e);
			return false;
		}
	}

	@Override
	public List<Forum> listforums() 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Forum ");
		List<Forum> listforums=query.list();
		session.close();
		return listforums;
	}

	@Override
	public Forum getforum(int forumid) 
	{
		Session session=sessionfactory.openSession();
		Forum forum=session.get(Forum.class, forumid);
		session.close();
		return forum;
	}

	@Override
	public boolean approveforum(Forum forum) 
	{
		try
		{
			forum.setStatus("Approve");
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised:"+e);
			return false;
		}
		
	}

	@Override
	public boolean rejectforum(Forum forum) 
	{
		try
		{
			forum.setStatus("Reject");
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised:"+e);
			return false;
		}
	}

	@Override
	public boolean updateforum(Forum forum) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised:"+e);
			return false;
		}
	}

}
