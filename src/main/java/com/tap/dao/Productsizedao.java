package com.tap.dao;
import java.util.List;
import com.tap.module.Productsize;
public interface Productsizedao {
	    void addProductSize(Productsize productSize);

	    Productsize getProductSize(int sizeId);

	    void updateProductSize(Productsize productSize);

	    void deleteProductSize(int sizeId);

	    List<Productsize> getAllProductSizes();

	    List<Productsize> getSizesByProduct(int productId);
	    
	}

