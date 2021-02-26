package com.cognixia.jump.dao;

import java.util.List;
import com.cognixia.jump.model.Product;
public interface ProductDAO {
	boolean addProduct(Product p);
	List<Product> getAllProducts();
	Product getProductById(int id);
	boolean updateProduct(Product p);
	boolean deleteProduct(int id);
}
