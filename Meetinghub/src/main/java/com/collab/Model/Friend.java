package com.collab.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="friendidseq",sequenceName="myblogseq")
public class Friend 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendidseq")
	int friendid;
	String friendname;
	String username;
	String status;
	
	public int getFriendid()
	{
		return friendid;
	}
	
	public void setFriendid(int friendid) 
	{
		this.friendid = friendid;
	}
	
	public String getFriendname()
	{
		return friendname;
	}
	
	public void setFriendname(String friendname)
	{
		this.friendname = friendname;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
}
