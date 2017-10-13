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
import com.spring.dao.ProductDAO;
import com.spring.model.Product;

@SuppressWarnings("unused")
@ComponentScan("com.spring")
public class ProductTest {
	
	
	@Autowired
	private static Product product;
	@Autowired
 private static ProductDAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		context.refresh();
		
		product=(Product) context.getBean("product");
		productDAO=(ProductDAO) context.getBean("productDAO");
	
	}
	
	@Test
	public void createProduct()
	{
		Product product=new Product();
		//product.setId(1);
		product.setName("xyz");
		product.setQuantity(100);
		product.setPrice(5);
		/*product.setId(24);
		product.setName("fgt");
		product.setQuantity(90);
		product.setPrice(700);*/
		
		boolean flag=productDAO.saveProduct(product);
		
		assertEquals("createProductTestCase", true, flag);
		
		
	}
	
}