package com.spring.dao;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Category;
import com.spring.model.Supplier;
import com.spring.model.Cart;

@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
	
	@Autowired
private SessionFactory sessionFactory;

public SupplierDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	
	}/*
@Transactional
	public boolean saveProduct(Product product) {
	
	sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}
*/
@Transactional
public boolean saveSupplier(Supplier supplier) {
	
	Session session=sessionFactory.getCurrentSession();
	session.saveOrUpdate(supplier);
	//session.flush();
	//Transaction tx=session.beginTransaction();
	//tx.commit();
	
	return true;
}
}
