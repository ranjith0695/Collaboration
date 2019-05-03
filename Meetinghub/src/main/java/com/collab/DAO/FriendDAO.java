package com.collab.DAO;

import java.util.List;

import com.collab.Model.Friend;
import com.collab.Model.Userinfo;

public interface FriendDAO 
{
	
	public List<Friend> listoffriends(String username);
	public List<Friend> pendingfriendrequest(String username);
	public List<Userinfo> suggestedfriends(String username);
	public boolean sendfriendrequest(Friend friend);
	public boolean acceptfriendrequest(int friendid);
	public boolean deletefriendrequest(int friendid);

}
