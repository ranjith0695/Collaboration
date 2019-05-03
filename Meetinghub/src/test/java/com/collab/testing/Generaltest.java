package com.collab.testing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Generaltest 
{
	public static void main (String[]args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
	}

}
