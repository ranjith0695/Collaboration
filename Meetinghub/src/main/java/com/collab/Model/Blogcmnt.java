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
@SequenceGenerator(name="cmntid",sequenceName="myblogseq")
public class Blogcmnt 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cmntid")
	int cmntid;
	int blogid;
	String cmnttext;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	Date cmntdate;
	String username;
	
	public int getCmntid() {
		return cmntid;
	}
	public void setCmntid(int cmntid) {
		this.cmntid = cmntid;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getCmnttext() {
		return cmnttext;
	}
	public void setCmnttext(String cmnttext) {
		this.cmnttext = cmnttext;
	}
	public Date getCmntdate() {
		return cmntdate;
	}
	public void setCmntdate(Date cmntdate) {
		this.cmntdate = cmntdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
