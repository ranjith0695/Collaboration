package com.collab.DAO;

import java.util.List;

import com.collab.Model.Forumcmnt;

public interface ForumcmntDAO 
{
	public boolean addforumcmnt(Forumcmnt forumcmnt);
	public boolean deleteforumcmnt(Forumcmnt forumcmnt);
	public List<Forumcmnt> listforumcmnts(int forumid);
	public Forumcmnt getforumcmnt(int forumcmntid);

}
