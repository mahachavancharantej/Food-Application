package com.tap.dao;

import java.util.List;
import com.tap.module.Order;
public interface Orderdao {
	    void addOrder(Order order);

	    Order getOrder(int orderId);

	    void updateOrder(Order order);

	    void deleteOrder(int orderId);

	    List<Order> getAllOrders();
	    List<Order> getOrdersByUser(int userId);

	    List<Order> getOrdersByRestaurant(int restaurantId);

	    void updateOrderStatus(int orderId, String status);
	    void updatePaymentStatus(int orderId, String paymentStatus);
	}

