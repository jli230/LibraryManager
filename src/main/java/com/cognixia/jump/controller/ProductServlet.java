package com.cognixia.jump.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.ProductDAO;
import com.cognixia.jump.dao.ProductDAOClass;
import com.cognixia.jump.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ProductDAO db;
	
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException{
    	this.db = new ProductDAOClass();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		List<Product> products = new ArrayList<Product>();
		if (id==null) {
			products = db.getAllProducts();
		} else {
			products.add(db.getProductById(Integer.parseInt(id)));
		}
		
		request.setAttribute("products", products);
		
		System.out.println(products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/viewproduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
		int qty = Integer.parseInt(request.getParameter("qty"));
		String description = request.getParameter("description");
		Product product = new Product(0,item,qty,description);
		
		db.addProduct(product);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

}
