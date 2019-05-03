package com.collab.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.Model.ProfilePic;

@Repository("profilepicDAO")
@Transactional
public class ProfilePicDAOimpl implements ProfilePicDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void save(ProfilePic profilepic)
	{
		System.out.println(" Save Method Profile Picture");
		Session session=sessionfactory.getCurrentSession();
		session.saveOrUpdate(profilepic);
		session.flush();
		System.out.println("Image Saved to Database");
		
	}

	@Override
	public ProfilePic getProfilepic(String username) 
	{

		Session session=sessionfactory.openSession();
		ProfilePic profilepic=(ProfilePic)session.get(ProfilePic.class,username);
		return profilepic;
	}
	

}
