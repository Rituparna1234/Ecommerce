package com.spring.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
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
	
	
	/*@Autowired
	private static Product product;
	*/

	@Autowired
	private static ProductDAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		context.refresh();
		
		//product=(Product) context.getBean("product");
		productDAO=(ProductDAO) context.getBean("productDAO");
	
	}
	@Test
	public void createProduct()
	{
		Product product=new Product();
		product.setName("cholocalte");
		product.setQuantity(5);
		product.setPrice(2500.12);
		product.setName("muffins");
		product.setQuantity(10);
		product.setPrice(1200);
		
		boolean flag=productDAO.saveProduct(product);
		
		assertEquals("createProductTestCase", true, flag);
		
		
	}
	
}