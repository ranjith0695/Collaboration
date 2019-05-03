package com.collab.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.DAO.FriendDAO;
import com.collab.Model.Friend;
import com.collab.Model.Userinfo;

public class Friendtesting 
{
	static FriendDAO friendDAO;
	
	@BeforeClass
	public static void executefirst()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
	@Ignore
	@Test
	public void sendfriendrequest()
	{
		Friend friend=new Friend();
		
		friend.setUsername("sundar345");
		friend.setFriendname("ajith");
		
		assertTrue("problem in Sending Friend Request",friendDAO.sendfriendrequest(friend));
	}
	
	@Ignore
	@Test
	public void acceptfriendrequest()
	{
		assertTrue("problem in accepting friend",friendDAO.acceptfriendrequest(2202));
	}
	
	@Ignore
	@Test
	public void deletefriendrequest()
	{
		assertTrue("problem in deleting friend",friendDAO.deletefriendrequest(2252));
	}
	
	@Test
	public void friendlist()
	{
		List<Friend> listoffriends=friendDAO.listoffriends("rahul666");
		assertTrue("problem in listing Friends",listoffriends.size()>0);
		System.out.println("*****Displaying Friend List*****");
		 for(Friend friend:listoffriends)
		 {
			 System.out.print(friend.getUsername()+"                 ");
			 System.out.println(friend.getFriendname());
		 }
	}
	
	@Test
	public void pendingfriendrequest()
	{
		List<Friend> pendingfriendrequest=friendDAO.pendingfriendrequest("rahul666");
		assertTrue("problem in listing Friends",pendingfriendrequest.size()>0);
		System.out.println("*****Displaying Pending Friend List*****");
		 for(Friend friend:pendingfriendrequest)
		 {
			 System.out.print(friend.getUsername()+"                 ");
			 System.out.println(friend.getFriendname());
		 }
	}
	
	@Test
	public void suggestedfriends()
	{
		List<Userinfo> listsuggestedfriends=friendDAO.suggestedfriends("rahul666");
		assertTrue("problem in listing Friends",listsuggestedfriends.size()>0);
		System.out.println("*****Displaying Suggested Friend List*****");
		 for(Userinfo user:listsuggestedfriends)
		 {
			 System.out.print(user.getUsername()+"                 ");
			 System.out.println(user.getCustomername());
		 }
	}


}
