<%@include file = "header.jsp" %>
	<h2>Add a Product:</h2>
	<form method="POST" action="ProductServlet">
		<label for="item">Product Name</label><br>
		<input type="text" name="item" id="item">
		<label for="qty">Quantity</label><br>
		<input type="number" name="qty" id="qty">
		<label for="description">Description</label><br>
		<input type="text" name="description" id="decription">
		<input type="submit">
	</form>
<%@include file = "footer.jsp" %>