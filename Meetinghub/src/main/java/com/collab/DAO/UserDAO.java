package com.collab.DAO;

import com.collab.Model.Userinfo;

public interface UserDAO 
{
	public boolean registeruser(Userinfo user);
	public boolean updateuser(Userinfo user);
	public boolean approveuser(Userinfo user);
	public boolean rejectuser(Userinfo user);
	public boolean makeoffline(Userinfo user);
	public boolean makeonline(Userinfo user);
	public Userinfo getuser(String username ); 


}
