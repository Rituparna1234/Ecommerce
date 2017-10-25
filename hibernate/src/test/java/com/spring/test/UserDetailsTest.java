/*package com.spring.test;
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

import com.spring.dao.UserDetailsDAO;

import com.spring.model.UserDetails;

@SuppressWarnings("unused")
@ComponentScan("com.spring")

@Ignore
public class UserDetailsTest 
{	
	@Autowired
	private static Product product;
	
	@Autowired
	private static UserDetailsDAO userdetailsDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.register(DBConfig.class);
		context.refresh();
		
	//	product=(Product) context.getBean("product");
		userdetailsDAO=(UserDetailsDAO) context.getBean("userdetailsDAO");
		
		
	}
	@Ignore
	@Test
	public void saveUserDetails()
	{
		UserDetails userdetails=new UserDetails();
		//cart.setId(1);
		userdetails.setName("XYZ");
		userdetails.setPrice(2500);
		userdetails.setAddress("gtduygwigf");
		userdetails.setQuantity(3);
		userdetails.setContactno(987654321);
		
		
		boolean flag=userdetailsDAO.saveUserDetails(userdetails);
		assertEquals("createUserDetailsTestCase", true, flag);
	}
	@Ignore
	@Test
	public void updateUserDetails()
	{
		UserDetails userdetails=new UserDetails();
		//cart.setId(1);
				userdetails.setName("XYZ");
				userdetails.setPrice(2500);
				userdetails.setAddress("gtduygwigf");
				userdetails.setQuantity(3);
				userdetails.setContactno(987654321);
	
		//boolean flag=cartDAO.updateCart(cart);
		assertEquals("problem in cart", userdetailsDAO.updateUserDetails(userdetails));
	}
	
	//@Ignore
	@Test
	public void deleteUserDetails()
	{
		UserDetails userdetails = new UserDetails();
		userdetails.setName("XYZ");
		userdetails.setPrice(2500);
		userdetails.setAddress("gtduygwigf");
		userdetails.setQuantity(3);
		userdetails.setContactno(987654321);
		boolean flag=userdetailsDAO.deleteUserDetails(162);
		assertEquals("createUserDetailsTestCase", true, flag);
	}
	
}


*/