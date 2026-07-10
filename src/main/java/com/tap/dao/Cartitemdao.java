package com.tap.dao;
import java.util.List;
import com.tap.module.CartItem;
public interface Cartitemdao {
	    void addCartItem(CartItem cartItem);

	    CartItem getCartItem(int cartItemId);

	    void updateCartItem(CartItem cartItem);

	    void deleteCartItem(int cartItemId);

	    List<CartItem> getAllCartItems();
	    List<CartItem> getCartItemsByCart(int cartId);

	    boolean updateQuantity(int cartItemId,int quantity);

	    boolean deleteCartItemByProduct(int cartId,int productId);

	    double getCartTotal(int cartId);

	    boolean clearCartItems(int cartId);
	    CartItem getCartItem(int cartId, int productId, int sizeId);

	    void updateCartItemQuantity(int cartItemId, int quantity, double totalPrice);
	}

