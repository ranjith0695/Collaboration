package com.collab.DAO;

import java.util.List;

import com.collab.Model.Job;

public interface JobDAO
{
	public boolean addjob(Job job);
	public boolean deletejob(Job job);
	public boolean updatejob(Job job);
	public Job getjob(int jobid);
	public List<Job> listjobs();


}
