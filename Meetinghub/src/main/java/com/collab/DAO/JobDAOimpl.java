package com.collab.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.Model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOimpl implements JobDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addjob(Job job)
	{
		try
		{
			sessionfactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public boolean deletejob(Job job) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public boolean updatejob(Job job)
	{
		try
		{
			sessionfactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured: "+e);
			return false;
		}
	}

	@Override
	public Job getjob(int jobid) 
	{
		Session session=sessionfactory.openSession();
		Job job=session.get(Job.class, jobid);
		session.close();
		return job;
	}

	@Override
	public List<Job> listjobs() 
	{
		Session session=sessionfactory.openSession();
	    Query query=session.createQuery("from Job where status='Approve'");
	    List<Job> listjobs=query.list();
	    session.close();
	    return listjobs;
	}

}
