package com.collab.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.Model.Userinfo;
@Repository("userDAO")
@Transactional
public class UserDAOimpl implements UserDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean registeruser(Userinfo user)
	{
		try
		{
			sessionfactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised: "+e);
			return false;
		}
	}

	@Override
	public boolean updateuser(Userinfo user) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised: "+e);
			return false;
		}
	}

	@Override
	public boolean approveuser(Userinfo user)
	{
		try
		{
			user.setStatus("Approve");
			sessionfactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised: "+e);
			return false;
		}
	}

	@Override
	public boolean rejectuser(Userinfo user) 
	{
		try
		{
			user.setStatus("Reject");
			sessionfactory.getCurrentSession().update(user);;
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised: "+e);
			return false;
		}
	}

	@Override
	public boolean makeoffline(Userinfo user) 
	{
		try
		{
			user.setIsonline("OFF");
			sessionfactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised: "+e);
			return false;
		}
	}

	@Override
	public boolean makeonline(Userinfo user) 
	{
		try
		{
			user.setIsonline("ON");
			sessionfactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Araised: "+e);
			return false;
		}
	}

	@Override
	public Userinfo getuser(String username)
	{
		Session session=sessionfactory.openSession();
		Userinfo user=session.get(Userinfo.class, username);
		session.close();
		return user;
	}

}
