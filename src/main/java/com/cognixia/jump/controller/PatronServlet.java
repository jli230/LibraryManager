package com.cognixia.jump.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.dao.PatronDAOClass;
import com.cognixia.jump.model.Patron;


/**
 * Servlet implementation class PatronServlet
 */

public class PatronServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PatronDAO db;
    
    @Override
    public void init() throws ServletException {
    	this.db = new PatronDAOClass();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("path:" + action);
		switch (action) {
		case "delete":
			deletePatron(request,response);
			break;
		case "viewAll":
			viewAllPatrons(request,response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("path:" + action);
		switch (action) {
		case "update":
			updatePatron(request, response);
			break;
		case "add":
			addPatron(request,response);
			break;
		case "unfreeze":
			unfreezeAccount(request,response);
			break;
		}
	}
	private void updatePatron(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("patron_id"));
		String first_name = request.getParameter("first_name");
		System.out.println(first_name);
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Patron patron = db.getPatronById(id);//check if patron is found
		System.out.println(patron);
		if (patron != null) {
			boolean status = patron.isAccount_frozen();
			Patron patronNew = new Patron(id, first_name, last_name, username, password, status);//must be initiated in if statement, otherwise will never be null
			System.out.println(patron);
			db.updatePatron(patronNew);
		} else {
			System.out.println("No patrons of that ID found.");
		}
		String STRING_DISPATCH = null;
		if (request.getParameter("account").equals("admin")) {
			STRING_DISPATCH = "/viewpatrons.jsp";
		} else {
			STRING_DISPATCH = "/";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(STRING_DISPATCH);
		dispatcher.forward(request, response);
	}
	
	
	private void viewAllPatrons(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		List<Patron> Patrons = new ArrayList<Patron>();
		
		if (id == null ) {
			 Patrons = db.getAllPatrons();
		} else {
			Patrons.add(db.getPatronById(Integer.parseInt(id))); 
		}
		
		
		request.setAttribute("Patrons", Patrons);

		System.out.println(Patrons);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/viewpatrons.jsp");
		dispatcher.forward(request, response);
	}
	private void deletePatron(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("patron_id"));
		Patron patron = db.getPatronById(id);
		if (patron !=null) {
			db.deletePatron(id);
		} else {
			System.out.println("No patron of that id found!");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/viewpatrons.jsp");
		dispatcher.forward(request, response);
	}
	private void addPatron(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int patronID = 0;//Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean accountFrozen = true;//Boolean.parseBoolean(request.getParameter("account_frozen"));
		
		System.out.println(patronID + " " + firstName + " " + lastName 
				+ " " + username + " " + password + " " + accountFrozen);
		
		
		Patron Patron = new Patron(patronID, firstName, lastName,
				username, password, accountFrozen);
		
		db.addPatron(Patron);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}
	private void unfreezeAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("decision"));
		
		int patronID = Integer.parseInt(request.getParameter("patron_id"));
		
		boolean accountFrozen = false;//Boolean.parseBoolean(request.getParameter("account_frozen"));
		
		System.out.println(patronID + " " + accountFrozen);
		
		db.updatePatronStatus(patronID, accountFrozen);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/viewpatrons.jsp");
		dispatcher.forward(request, response);
	}

}