package com.tap.dao;
import java.util.List;

import com.tap.module.Menu;
public interface Menudao {
	
	    void addMenu(Menu menu);

	    Menu getMenu(int productId);

	    void updateMenu(Menu menu);

	    void deleteMenu(int productId);

	    List<Menu> getAllMenus();
	    List<Menu> getMenusByRestaurant(int restaurantId);

	    List<Menu> getMenusByCategory(int categoryId);

	    List<Menu> searchMenus(String keyword);
	}

