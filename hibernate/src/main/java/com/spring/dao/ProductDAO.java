package com.spring.dao;

import java.util.List;

import com.spring.model.Cart;
import com.spring.model.Product;

public interface ProductDAO {
	
	public boolean saveProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int id);
	public Product getProductItem(int ProductItemId);
	public List<Product> getProductItems(String username);


}


