package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Cart;
import com.spring.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {
@Autowired
SessionFactory sessionFactory;
@Transactional
public boolean saveProduct(Product product) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e){
		
		return false;
		}
	}
@Transactional
	public boolean updateProduct(Product product) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e){
		
		return false;
		}
	}
@Transactional
/*public boolean deleteCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e){
		
		return false;
		}
		}
		*/
public boolean deleteProduct(int id) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE id = "+id).executeUpdate();
	return true;
}

@Transactional
	public Product getProductItem(int ProductItemId) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,ProductItemId);
		session.close();
		session.flush();
		return product;
	}
		
@Transactional
	public List<Product> getProductItems(String username) {
		List<Product> product = new ArrayList<Product>();
        Transaction trns = null;
        Session session =sessionFactory.openSession();
        try {
            trns = (Transaction) session.beginTransaction();
            product = session.createQuery("from product").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return product;
}
	}
