package com.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.dao.CartDAOImpl;
import com.spring.dao.CategoryDAOImpl;
import com.spring.dao.ProductDAOImpl;
import com.spring.dao.SupplierDAOImpl;
import com.spring.dao.UserDetailsDAOImpl;
import com.spring.model.Cart;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.model.Supplier;
import com.spring.model.UserDetails;
//import com.spring.model.UserDetails;


@Configuration
@ComponentScan("com.spring")
@EnableTransactionManagement
@Component
public class DBConfig  {
	 @Bean(name = "dataSource")
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
			System.out.println("Datasource");
			return dataSource;

		}

		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			properties.put("hibernate.hbm2ddl.auto", "update");
			System.out.println("Hibernate Properties");
			return properties;

		}

		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(Product.class);
		     sessionBuilder.addAnnotatedClass(Category.class);
		     sessionBuilder.addAnnotatedClass(UserDetails.class);
		    sessionBuilder.addAnnotatedClass(Cart.class);
		     sessionBuilder.addAnnotatedClass(Supplier.class);
			sessionBuilder.scanPackages("com.spring");
			System.out.println("Session");
			
			return sessionBuilder.buildSessionFactory();
			
		}

		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			System.out.println("Transaction");
			return transactionManager;
		}
		
	//Factory Design pattern
	@Autowired
	@Bean(name= "productDAO")
	public ProductDAOImpl getProductDAO(SessionFactory sessionFactory) {
	    return  new ProductDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name= "categoryDAO")
	public CategoryDAOImpl getCategoryDAO(SessionFactory sessionFactory) {
	    return new CategoryDAOImpl(sessionFactory);
}
	
	
	@Autowired
	@Bean(name= "supplierDAO")
	public SupplierDAOImpl getSupplierDAO(SessionFactory sessionFactory) {
	    return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name= "cartDAO")
	public CartDAOImpl getCartDAO(SessionFactory sessionFactory) {
	    return new CartDAOImpl();
	}
	@Autowired
	@Bean(name= "userdetailsDAO")
	public UserDetailsDAOImpl getUserDetailsDAO(SessionFactory sessionFactory) {
	    return new UserDetailsDAOImpl(sessionFactory);
	}
	
}