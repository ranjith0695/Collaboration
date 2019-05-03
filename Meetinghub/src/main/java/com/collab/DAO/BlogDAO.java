package com.collab.DAO;

import java.util.List;

import com.collab.Model.Blog;

public interface BlogDAO 
{
	public boolean addblog(Blog blog);
	public boolean deleteblog(Blog blog);
	public boolean updateblog(Blog blog);
	public List<Blog> listblogs();
	public Blog getblog(int blogid);
	public boolean incrementlikes(Blog blog);
	public boolean incrementdislikes(Blog blog);
	public boolean approveblog(Blog blog);
	public boolean rejectblog(Blog blog);

}
