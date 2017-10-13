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
import com.spring.model.Category;


@SuppressWarnings("unused")
@ComponentScan("com.spring")
public class CategoryTest {
	
	
	@Autowired
	private static Category category;
	@Autowired	
 private static CategoryDAO categoryDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		//context.scan("com.spring.*");
		context.refresh();
		
		category=(Category) context.getBean("category");
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
	
	}
	@Test
	public void createCategory()
	{
		Category category=new Category();
		
		category.setName("abc");
		category.setQuantity(25);
		category.setPrice(467);
	
		boolean flag=categoryDAO.saveCategory(category);
		
		assertEquals("createCategoryTestCase", true, flag);
		
		
	}
	
	
}