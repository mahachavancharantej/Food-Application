package com.tap.dao;
import java.util.List;
import com.tap.module.Category;
public interface Categorydao {
	    void addCategory(Category category);

	    Category getCategory(int categoryId);

	    void updateCategory(Category category);

	    void deleteCategory(int categoryId);

	    List<Category> getAllCategories();
	}
