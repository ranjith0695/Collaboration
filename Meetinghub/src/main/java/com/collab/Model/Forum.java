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
@SequenceGenerator(name="forumid",sequenceName="myblogseq")
public class Forum 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumid")
	int forumid;
	String forumname;
	String forumcontent;
	String username;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	Date createddate;
	String status;
	
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	public String getForumcontent() {
		return forumcontent;
	}
	public void setForumcontent(String forumcontent) {
		this.forumcontent = forumcontent;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
