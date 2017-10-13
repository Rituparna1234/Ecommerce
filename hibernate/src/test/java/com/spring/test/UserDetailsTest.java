package com.spring.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.spring.config.DBConfig;
import com.spring.dao.CategoryDAO;
import com.spring.dao.UserDetailsDAO;
import com.spring.model.Category;
import com.spring.model.UserDetails;


@SuppressWarnings("unused")
@ComponentScan("com.spring")
public class UserDetailsTest {
	
	
	@Autowired
	private static UserDetails userDetails;
	@Autowired	
 private static UserDetailsDAO userdetailsDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		//context.scan("com.spring.*");
		context.refresh();
		
		userDetails=(UserDetails) context.getBean("userdetails");
		userdetailsDAO=(UserDetailsDAO) context.getBean("userdetailsDAO");
		
	
	}
	@Test
	public void createUserDetails()
	{
		UserDetails userdetails=new UserDetails();
		//userdetails.setId(76);
		userdetails.setName("abc");
		userdetails.setQuantity(25);
		userdetails.setPrice(467);
		userdetails.setAddress("xyz");
		userdetails.setContactno(987654321);
	
		boolean flag=userdetailsDAO.saveUserDetails(userdetails);
		
		assertEquals("createUserDetailsTestCase", true, flag);
		
		
	}
	
	
}