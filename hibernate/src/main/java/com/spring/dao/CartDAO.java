package com.spring.dao;

import java.util.List;

import com.spring.model.Cart;

public interface CartDAO {
	public boolean saveCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(int id);
	public Cart getCartItem(int CartItemId);
	public List<Cart> getCartItems(String username);


}
