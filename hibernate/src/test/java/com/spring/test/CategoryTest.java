
/*package com.spring.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.config.DBConfig;
import com.spring.dao.CategoryDAO;
import com.spring.model.Category;
@SuppressWarnings("unused")
@ComponentScan("com.spring")

@Ignore
public class CategoryTest {
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		context.scan("com.spring.*");
		context.refresh();
	
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	
	
	@Test
	public void saveCategory()
	{
		Category category=new Category();
		category.setCategory_Name("fig");
		category.setCategory_Description("dwyud");
		boolean flag=categoryDAO.saveCategory(category);
		assertEquals("createCategoryTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateCategory()
	{
		Category category=new Category();
		boolean flag=categoryDAO.saveCategory(1);
		assertEquals("createCategoryTestCase", true, flag);
	}
	@Test
	public void getAllCategoryList()
	{
		Category category=new Category();
		List<Category> flag=( categoryDAO).getAllCategoryList();
		assertNotNull("problem in getting category by Cid", category);
	}
}
*/