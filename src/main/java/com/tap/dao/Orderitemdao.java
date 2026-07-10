package com.tap.dao;
import java.util.List;
import com.tap.module.Orderitem;
public interface Orderitemdao {
	
	    void addOrderItem(Orderitem orderItem);

	    Orderitem getOrderItem(int orderItemId);

	    void updateOrderItem(Orderitem orderItem);

	    void deleteOrderItem(int orderItemId);

	    List<Orderitem> getAllOrderItems();
	    List<Orderitem> getOrderItemsByOrder(int orderId);
	}

