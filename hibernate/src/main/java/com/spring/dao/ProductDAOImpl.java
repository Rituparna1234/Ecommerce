package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Cart;
import com.spring.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	
	@Autowired
private SessionFactory sessionFactory;

public ProductDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	
	}/*
@Transactional
	public boolean saveProduct(Product product) {
	
	sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}
*/

@Transactional
public boolean saveProduct(Product product) {
	
	Session session=sessionFactory.getCurrentSession();
	//Transaction tx=session.beginTransaction();
	session.saveOrUpdate(product);
	//tx.commit();
	
	//session.close();
	return true;
}
}

/*public boolean addProduct(Product product) {
	// TODO Auto-generated method stub
	return false;
}

public boolean updateProduct(Product product) {
	// TODO Auto-generated method stub
	return false;
}

public boolean deleteProduct(Product product) {
	// TODO Auto-generated method stub
	return false;
}

public Cart getCartItem(int CartItemId) {
	// TODO Auto-generated method stub
	return null;
}

public List<Cart> getCartItems(String username) {
	// TODO Auto-generated method stub
	return null;
}
}
*/