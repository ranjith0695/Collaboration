package com.collab.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.DAO.JobDAO;
import com.collab.Model.Job;

public class Jobtesting 
{
	static JobDAO jobDAO;
	
	@BeforeClass
	public static void executefirst()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
        jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
	@Ignore
	@Test
	public void addjob()
	{
		Job job=new Job();
		job.setDesignation("TL");
		job.setJobdesc("To work on a project");
		job.setQualification("5 years experience in relevant field");
		job.setCreateddate(new java.util.Date());
		job.setStatus("Approve");
		assertTrue("problem in adding job",jobDAO.addjob(job));
	}
	
	@Ignore
	@Test
	public void deletejob()
	{
		Job job=jobDAO.getjob(1152);
		assertTrue("problem in deleting job",jobDAO.deletejob(job));
	}
	
	@Ignore
	@Test
	public void updatejob()
	{
		Job job=jobDAO.getjob(1102);
		job.setQualification("7yrs experience in software field");
		assertTrue("problem in updating job",jobDAO.updatejob(job));
	}
	
	
	@Test
	public void listjobs()
	{
		List<Job> listjobs=jobDAO.listjobs();
		assertTrue("problem in listing job",listjobs.size()>0);
		for(Job job:listjobs)
		{
			System.out.print(job.getJobid()+"\t");
			System.out.print(job.getDesignation()+"\t");
			System.out.print(job.getJobdesc()+"\t");
			System.out.print(job.getQualification()+"\t");
			System.out.println(job.getCreateddate());
			
		}
		
	}
	


}
