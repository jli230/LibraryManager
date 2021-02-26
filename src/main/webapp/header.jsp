<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cognixia.jump.controller.LoginServlet"%>
<!--  %@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Catalog</title>
</head>
<body>
	<nav>
		<a href="<%= request.getContextPath()%>">Home</a>   
		<a href="<%= request.getContextPath()%>/login.jsp">Login</a>
<%
	LoginServlet loginStatus = new LoginServlet();
	if(loginStatus.isLibrarianLoggedIn() == true){
%>
		<a href="<%= request.getContextPath()%>/updatepatronsadmin.jsp">Update Account</a>
		<a href="<%= request.getContextPath()%>/viewpatrons.jsp">View and Unfreeze Patrons</a> 
	</nav>
	You are currently logged in as a: Librarian
<%
	}
	else if(loginStatus.isPatronLoggedIn() == true){
%>
	
		<a href="<%= request.getContextPath()%>/updatepatrons.jsp">Update Account</a>
	</nav>
	You are currently logged in as a: Patron
<%
	}
	else {
%>

<%

	}

%>


<!--  >nav>Insert Nav Here</nav-->
	
<!-- 		<a href="#./PatronServlet">Relative</a>      -->
	  
<!-- 		<a href="<%= request.getContextPath()%>/addpatrons.jsp">Add Patrons</a>    -->

		<!--  >form method="GET" action=ProductServlet>
			<input type="number" min="1" placeholder="product id" name="id">
			<input type="submit" value="Search Products"/>
		</form-->
	</nav>