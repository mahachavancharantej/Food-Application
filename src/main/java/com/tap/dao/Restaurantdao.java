package com.tap.dao;
import com.tap.module.Restaurant;
import java.util.List;
public interface Restaurantdao {
	    void addRestaurant(Restaurant restaurant);
	    Restaurant getRestaurant(int restaurantId);
	    void updateRestaurant(Restaurant restaurant);
	    void deleteRestaurant(int restaurantId);
	    List<Restaurant> getAllRestaurants();
	    List<Restaurant> getRestaurantsByStatus(String status);

	    List<Restaurant> searchRestaurants(String keyword);
	}
