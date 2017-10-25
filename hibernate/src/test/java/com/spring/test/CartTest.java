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
import com.spring.dao.CartDAO;
import com.spring.dao.UserDetailsDAO;
import com.spring.model.Cart;
import com.spring.model.UserDetails;

@SuppressWarnings("unused")
@ComponentScan("com.spring")

@Ignore
public class CartTest 
{	
	@Autowired
	private static Product product;
	
	@Autowired
	private static CartDAO cartDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.register(DBConfig.class);
		context.refresh();
		
	//	product=(Product) context.getBean("product");
		cartDAO=(CartDAO) context.getBean("cartDAO");
		
		
	}
	@Ignore
	@Test
	public void saveCart()
	{
		Cart cart=new Cart();
		//cart.setId(1);
		cart.setName("XYZ");
		cart.setPrice(2500);
		cart.setAddress("gtduygwigf");
		cart.setQuantity(3);
		cart.setContactno(987654321);
		
		
		boolean flag=cartDAO.saveCart(cart);
		assertEquals("createcartTestCase", true, flag);
	}
	@Ignore
	@Test
	public void updateCart()
	{
	     Cart cart=new Cart();
		//cart.setId(1);
				cart.setName("XYZ");
				cart.setPrice(2500);
				cart.setAddress("gtduygwigf");
				cart.setQuantity(3);
				cart.setContactno(987654321);
	
		//boolean flag=cartDAO.updateCart(cart);
		assertEquals("problem in cart", cartDAO.updateCart(cart));
	}
	
	//@Ignore
	@Test
	public void deleteCart()
	{
		Cart cart = new Cart();
		cart.setName("XYZ");
		cart.setPrice(2500);
		cart.setAddress("gtduygwigf");
		cart.setQuantity(3);
		cart.setContactno(987654321);
		boolean flag=cartDAO.deleteCart(162);
		assertEquals("createCartTestCase", true, flag);
	}
	
}


*/