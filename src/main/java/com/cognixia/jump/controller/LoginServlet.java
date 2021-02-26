package com.cognixia.jump.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.dao.PatronDAOClass;
import com.cognixia.jump.model.Patron;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private String librarianUser;
	private String password;
	
	private PatronDAO db;
	
	private static int currentUserID = 0;
	private static boolean patronLoggedIn = false;
	private static boolean librarianLoggedIn = false;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		conn = ConnectionManager.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from patron where username = ? and password = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.db = new PatronDAOClass();
		password = "123";
		librarianUser = "librarian";
		

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("user");
		String userPassword = req.getParameter("userpassword");
		boolean retrieved = false;
		String username_test = null;
		
		try {
			
			if(username.matches(librarianUser) && userPassword.equals(password)) {}
			else {
				pstmt.setString(1, username);
				pstmt.setString(2, userPassword);
				
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				
				username_test = rs.getString("username") + " " + rs.getString("password");
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(username.matches(librarianUser) && userPassword.equals(password)) {
			
			
			//Ensures that the system recognizes that a librarian has logged in.
			librarianLoggedIn = true;
			patronLoggedIn = false;
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		}else if(username_test != null) {
			
			
			//Ensures that the system recognizes that a patron has logged in.
			patronLoggedIn = true;
			librarianLoggedIn = false;
			
			PatronDAOClass patronDAO = new PatronDAOClass();
			List<Patron> patronList = patronDAO.getAllPatrons();
			
			for (Patron patron : patronList){
				if(patron.getUsername().equals(username)) {
					currentUserID = patron.getId();
				}
			}
			
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
			System.out.println("Could not log in the user/ not in database");
			dispatcher.forward(req, resp);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
       
   
	
	
	
	
	
	
	
	public static boolean isPatronLoggedIn() {
		return patronLoggedIn;
	}

	public static boolean isLibrarianLoggedIn() {
		return librarianLoggedIn;
	}

	public static int getCurrentUserID() {
		return currentUserID;
	}
	public void setLibrarianUser(String librarianUser) {
		this.librarianUser = librarianUser;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}