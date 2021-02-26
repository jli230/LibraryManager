<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Catalog</title>
</head>
<body>
	<nav>
	<a href="./ProductServlet">Relative</a>
	<a href="<%= request.getContextPath()%>/">Home</a>
	<a href="<%= request.getContextPath()%>/addproduct.jsp">Add Products</a>
	<a href="<%= request.getContextPath()%>/ProductServlet">View Products</a>
	<form method="GET" action=ProductServlet>
		<input type="number" min="1" placeholder="product id" name="id">
		<input type="submit">
	</form>
	</nav>