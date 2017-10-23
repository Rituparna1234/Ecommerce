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
import com.spring.dao.CartDAO;
import com.spring.dao.ProductDAO;
import com.spring.model.Cart;
import com.spring.model.Product;

@SuppressWarnings("unused")
@ComponentScan("com.spring")
public class ProductTest 
{	
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
		
	//	product=(Product) context.getBean("product");
		productDAO=(ProductDAO) context.getBean("productDAO");
		
		
	}
	@Ignore
	@Test
	public void saveProduct()
	{
		Product product=new Product();
		//cart.setId(1);
		product.setName("XYZ");
		product.setPrice(2500);
		//product.setId(78);
		product.setQuantity(3);
		
		boolean flag=productDAO.saveProduct(product);
		assertEquals("createCartTestCase", true, flag);
	}
	@Ignore
	@Test
	public void updateProduct()
	{
		Product product=new Product();
		product.setName("XYZ");
		product.setPrice(2500);
		product.setQuantity(3);
		
	
		
		assertEquals("problem in cart", productDAO.updateProduct(product));
	}
	
	//@Ignore
	@Test
	public void deleteProduct()
	{
		Product product = new Product();
		product.setName("xyz");
		product.setQuantity(10);
		product.setPrice(500);
		boolean flag=productDAO.deleteProduct(98);
		assertEquals("createproductTestCase", true, flag);
	}
	
}


