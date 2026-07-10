package com.tap.dao;
import java.util.List;
import com.tap.module.Cart;
public interface Cartdao {
	    void addCart(Cart cart);

	    Cart getCart(int cartId);

	    void updateCart(Cart cart);

	    void deleteCart(int cartId);

	    List<Cart> getAllCarts();
	    Cart getCartByUser(int userId);

	    void clearCart(int cartId);
	}

