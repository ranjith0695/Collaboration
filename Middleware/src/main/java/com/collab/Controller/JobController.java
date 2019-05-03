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

import com.collab.DAO.JobDAO;
import com.collab.Model.Job;

@RestController
public class JobController
{
	@Autowired
	JobDAO jobDAO;
	
	@PostMapping(value="/addjob")
	public ResponseEntity<?> addjob(@RequestBody Job job)
	{
		job.setCreateddate(new java.util.Date());
		job.setStatus("Approve");
		if(jobDAO.addjob(job))
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updatejob")
	public ResponseEntity<String> updatejob(@RequestBody Job job)
	{
		if(jobDAO.updatejob(job))
		{
			return new ResponseEntity<String>("successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deletejob/{jobid}")
	public ResponseEntity<?> deletejob(@PathVariable("jobid") int jobid)
	{
		Job job= jobDAO.getjob(jobid);
		if(jobDAO.deletejob(job))
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getjob/{jobid}")
	public ResponseEntity<Job> getjob(@PathVariable("jobid") int jobid)
	{
		Job job=jobDAO.getjob(jobid);
		
		if(job!=null)
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Job>(job,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/listjobs")
	public ResponseEntity<List<Job>> listjobs()
	{
		List<Job> listjobs=jobDAO.listjobs();
		
		if(listjobs.size()>0)
		{
			return new ResponseEntity<List<Job>>(listjobs,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(listjobs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
