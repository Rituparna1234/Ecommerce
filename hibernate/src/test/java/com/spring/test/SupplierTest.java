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
import com.spring.dao.SupplierDAO;
import com.spring.model.Category;
import com.spring.model.Supplier;


@SuppressWarnings("unused")
@ComponentScan("com.spring")
public class SupplierTest {
	
	
	@Autowired
	private static Supplier supplier;
	@Autowired	
 private static SupplierDAO supplierDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		//context.scan("com.spring.*");
		context.refresh();
		
		supplier=(Supplier) context.getBean("supplier");
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		
	
	}
	@Test
	public void createSupplier()
	{
		Supplier supplier=new Supplier();
		
		supplier.setName("abc");
		supplier.setQuantity(25);
		supplier.setPrice(467);
	
		boolean flag=supplierDAO.saveSupplier(supplier);
		
		assertEquals("createSupplierTestCase", true, flag);
		
		
	}
	
	
}