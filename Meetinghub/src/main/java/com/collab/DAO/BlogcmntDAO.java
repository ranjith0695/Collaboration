package com.collab.DAO;

import java.util.List;

import com.collab.Model.Blogcmnt;

public interface BlogcmntDAO 
{
	public boolean addblogcmnt(Blogcmnt blogcmnt);
	public boolean deleteblogcmnt(Blogcmnt blogcmnt);
	public boolean updateblogcmnt(Blogcmnt blogcmnt);
	public List<Blogcmnt> listblogcmnts(int blogid);
	public Blogcmnt getblogcmnt(int cmntid);

}
