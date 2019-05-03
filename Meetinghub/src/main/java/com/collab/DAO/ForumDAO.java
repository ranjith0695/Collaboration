package com.collab.DAO;

import java.util.List;

import com.collab.Model.Forum;

public interface ForumDAO 
{
	public boolean addforum(Forum forum);
	public boolean deleteforum(Forum forum);
	public boolean updateforum(Forum forum);
	public List<Forum> listforums();
	public Forum getforum(int forumid);
	public boolean approveforum(Forum forum);
	public boolean rejectforum(Forum forum);

}
