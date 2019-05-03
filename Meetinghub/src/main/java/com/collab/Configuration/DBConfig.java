package com.collab.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.collab.Model.Blog;
import com.collab.Model.Blogcmnt;
import com.collab.Model.Forum;
import com.collab.Model.Forumcmnt;
import com.collab.Model.Friend;
import com.collab.Model.Job;
import com.collab.Model.ProfilePic;
import com.collab.Model.Userinfo;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.collab")
public class DBConfig
{

	@Bean(name="DataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("ranjith66");
		datasource.setPassword("123456");
		System.out.println("DataSource created");
		return datasource;
	}
	
	@Bean(name="SessionFactory")
	public SessionFactory getSessionFactory() 
	{
		Properties hibernatepro=new Properties();
		hibernatepro.put("hibernate.hbm2ddl.auto", "update");
		hibernatepro.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect" );
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getDataSource());
		factory.addProperties(hibernatepro);
        factory.addAnnotatedClass(Blog.class);
        factory.addAnnotatedClass(Userinfo.class);
        factory.addAnnotatedClass(Job.class);
        factory.addAnnotatedClass(Blogcmnt.class);
        factory.addAnnotatedClass(Forum.class);
        factory.addAnnotatedClass(Forumcmnt.class);
        factory.addAnnotatedClass(Friend.class);
        factory.addAnnotatedClass(ProfilePic.class);
		System.out.println("Session Factory Created");
		return factory.buildSessionFactory();
				
	}
	
	@Bean(name="HibernateTransactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory)
	{
		System.out.println("Hibernate Transaction Manager Created");
		return new HibernateTransactionManager(sessionfactory);
	}


}
