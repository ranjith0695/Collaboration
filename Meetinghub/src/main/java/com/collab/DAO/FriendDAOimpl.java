package com.collab.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.Model.Friend;
import com.collab.Model.Userinfo;

@Repository("friendDAO")
@Transactional
public class FriendDAOimpl implements FriendDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List<Friend> listoffriends(String username) 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Friend where (username=:uname or friendname=:frndname) and status='Accepted'");
		query.setParameter("uname", username);
		query.setParameter("frndname", username);
		List<Friend> listoffriends=(List<Friend>)query.list();
		session.close();
		return listoffriends;
	}

	@Override
	public List<Friend> pendingfriendrequest(String username) 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Friend where friendname=:frndname and status='Pending'");
		query.setParameter("frndname", username);
		List<Friend> pendingfriendrequest=(List<Friend>)query.list();
		session.close();
		return pendingfriendrequest;
	}

	@Override
	public List<Userinfo> suggestedfriends(String username) 
	{
		Session session=sessionfactory.openSession();
		Query sqlQuery=session.createSQLQuery("select username from Userinfo where username not in(select friendname from Friend where username='"+username+"') and username not in(select username from Friend where friendname='"+username+"' and status='Accepted') and username!='"+username+"'");
		List<String> listUsers=(List<String>)sqlQuery.list();
		ArrayList<Userinfo> listUserinfo=new ArrayList<Userinfo>();
		int i=0;
		while(i<listUsers.size())
		{
			Userinfo user=session.get(Userinfo.class, listUsers.get(i).toString().trim());
			listUserinfo.add(user);
			i++;
			
		}
		session.close();
		return listUserinfo;
	}

	@Override
	public boolean sendfriendrequest(Friend friend) 
	{
		try
		{
			friend.setStatus("Pending");
			sessionfactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean acceptfriendrequest(int friendid) 
	{
		 try
	        {
	        	Session session=sessionfactory.openSession();
	        	Friend friend=session.get(Friend.class, friendid);
	        	session.close();
	        	friend.setStatus("Accepted");
	        	sessionfactory.getCurrentSession().update(friend);
	        	return true;
	        	
	        }
	        catch(Exception e)
	        {
			    return false;
	        }
	}

	@Override
	public boolean deletefriendrequest(int friendid) 
	{
		try
        {
        	Session session=sessionfactory.openSession();
        	Friend friend=session.get(Friend.class, friendid);
        	session.close();
        	friend.setStatus("Accepted");
        	sessionfactory.getCurrentSession().delete(friend);
        	return true;
        	
        }
        catch(Exception e)
        {
		    return false;
        }
	}

}
