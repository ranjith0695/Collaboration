package com.collab.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.Model.Blogcmnt;
@Repository("blogcmntDAO")
@Transactional
public class BlogcmntDAOimpl implements BlogcmntDAO

{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addblogcmnt(Blogcmnt blogcmnt) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(blogcmnt);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public boolean deleteblogcmnt(Blogcmnt blogcmnt) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(blogcmnt);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public List<Blogcmnt> listblogcmnts(int blogid) 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Blogcmnt where blogid=:myblogid");
		query.setParameter("myblogid", blogid);
		List<Blogcmnt> listblogcmnts=query.list();
		session.close();
		return listblogcmnts;
	}

	@Override
	public Blogcmnt getblogcmnt(int cmntid) 
	{
		Session session=sessionfactory.openSession();
		Blogcmnt blogcmnt=session.get(Blogcmnt.class,cmntid);
		session.close();
		return blogcmnt;
	}

	@Override
	public boolean updateblogcmnt(Blogcmnt blogcmnt) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(blogcmnt);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

}
