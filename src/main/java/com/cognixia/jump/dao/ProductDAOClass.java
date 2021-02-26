package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Product;

public class ProductDAOClass implements ProductDAO {
	private static final Connection conn = ConnectionManager.getConnection();
	private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
	private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id=?";
	private static final String ADD_PRODUCT = "INSERT INTO product(item, qty, description) values (?, ?, ?)";
	private static final String UPDATE_PRODUCT = "UPDATE product SET item = ?, qty = ?, description = ?, WHERE id=?";
	private static final String DELETE_PRODUCTS = "DELETE FROM product WHERE id=?";
	@Override
	public boolean addProduct(Product p) {
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_PRODUCT);){
			pstmt.setString(1, p.getItem());
			pstmt.setInt(2, p.getQty());
			pstmt.setString(3, p.getDescription());
			if (pstmt.executeUpdate() >0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PRODUCTS);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()) {
				products.add(new Product(rs.getInt("id"),
						rs.getString("item"), 
						rs.getInt("qty"), 
						rs.getString("description")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Product getProductById(int id) {
		Product product = null;
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_PRODUCT_BY_ID);) {
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				product=new Product(rs.getInt("id"),
						rs.getString("item"), 
						rs.getInt("qty"), 
						rs.getString("description"));
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
