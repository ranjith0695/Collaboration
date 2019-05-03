package com.collab.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@SequenceGenerator(name="forumcmntid",sequenceName="myblogseq")
public class Forumcmnt 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumcmntid")
	int forumcmntid;
	int forumid;
	String fcmnt;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	Date fcmntdate;
	String username;
	
	public int getForumcmntid() 
	{
		return forumcmntid;
	}
	
	public void setForumcmntid(int forumcmntid) 
	{
		this.forumcmntid = forumcmntid;
	}
	
	public int getForumid()
	{
		return forumid;
	}
	
	public void setForumid(int forumid) 
	{
		this.forumid = forumid;
	}
	
	public String getFcmnt() 
	{
		return fcmnt;
	}
	public void setFcmnt(String fcmnt)
	{
		this.fcmnt = fcmnt;
	}
	public Date getFcmntdate() 
	{
		return fcmntdate;
	}
	public void setFcmntdate(Date fcmntdate)
	{
		this.fcmntdate = fcmntdate;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	

}
