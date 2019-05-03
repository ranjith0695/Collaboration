package com.collab.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.Model.Forumcmnt;

@Repository("forumcmntDAO")
@Transactional
public class ForumcmntDAOimpl implements ForumcmntDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addforumcmnt(Forumcmnt forumcmnt) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(forumcmnt);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised : "+e);
			return false;
		}
	}

	@Override
	public boolean deleteforumcmnt(Forumcmnt forumcmnt) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(forumcmnt);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised : "+e);
			return false;
		}
	}

	@Override
	public List<Forumcmnt> listforumcmnts(int forumid)
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Forumcmnt where forumid=:myforumid");
		query.setParameter("myforumid", forumid );
		List<Forumcmnt> listforumcmnts=query.list();
		session.close();
		return listforumcmnts;
	}

	@Override
	public Forumcmnt getforumcmnt(int forumcmntid) 
	{
		Session session=sessionfactory.openSession();
		Forumcmnt forumcmnt=session.get(Forumcmnt.class,forumcmntid);
		session.close();
		return forumcmnt;
	}

}
