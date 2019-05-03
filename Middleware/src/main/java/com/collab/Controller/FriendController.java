package com.collab.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collab.DAO.FriendDAO;
import com.collab.Model.Friend;
import com.collab.Model.Userinfo;

@RestController
public class FriendController 
{
	@Autowired
	FriendDAO friendDAO;
	
	@GetMapping(value="/listfriends/{username}")
	public ResponseEntity<List<Friend>> listfriends(@PathVariable("username") String username)
	{
		List<Friend> listfriends=friendDAO.listoffriends(username);
		if(listfriends.size()>0)
		{
			return new ResponseEntity<List<Friend>>(listfriends,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(listfriends,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/pendingfriendrequest/{username}")
	public ResponseEntity<List<Friend>> pendingfriendrequest(@PathVariable("username") String username)
	{
		List<Friend> pendingfriends=friendDAO.pendingfriendrequest(username);
		if(pendingfriends.size()>0)
		{
			return new ResponseEntity<List<Friend>>(pendingfriends,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(pendingfriends,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/suggestedfriends/{username}")
	public ResponseEntity<List<Userinfo>> suggestedfriends(@PathVariable("username") String username)
	{
		List<Userinfo> suggestedfriends=friendDAO.suggestedfriends(username);
		if(suggestedfriends.size()>0)
		{
			return new ResponseEntity<List<Userinfo>>(suggestedfriends,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Userinfo>>(suggestedfriends,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/acceptfriendrequest/{friendid}")
	public ResponseEntity<String> acceptfriendrequest(@PathVariable("friendid") int friendid)
	{
		if(friendDAO.acceptfriendrequest(friendid))
		{
			return new ResponseEntity<String>("successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deletefriendrequest/{friendid}")
	public ResponseEntity<String> deletefriendrequest(@PathVariable("friendid") int friendid)
	{
		if(friendDAO.deletefriendrequest(friendid))
		{
			return new ResponseEntity<String>("successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/sendfriendrequest")
	public ResponseEntity<?> sendfriendrequest(@RequestBody Friend friend)
	{
		if(friendDAO.sendfriendrequest(friend))
		{
			return new ResponseEntity<Friend>(friend,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
