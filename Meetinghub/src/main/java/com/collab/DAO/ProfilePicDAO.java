package com.collab.DAO;

import com.collab.Model.ProfilePic;

public interface ProfilePicDAO 
{
	
	public void save(ProfilePic profilepic);
	public ProfilePic getProfilepic(String username);

}
