<%@ include file="header.jsp" %>

	<h2>Update A Patron:</h2>
	<form method="POST" action="PatronServlet">
		<input type="hidden" name="action" id="action" value="update"><br>
		<input type="hidden" name="account" id="account" value="admin"><br>
		<label for="patron_id">Patron ID</label><br>
		<input type="number" name="patron_id" id="patron_id"><br>
		<label for="first_name">Patron First Name</label><br>
		<input type="text" name="first_name" id="first_name"><br>		
		<label for="last_name">Patron Last Name</label><br>
		<input type="text" name="last_name" id="last_name"><br>
		<label for="username">Username</label><br>
		<input type="text" name="username" id="username"><br>
		<label for="password">Password</label><br>
		<input type="password" name="password" id="password"><br>
			<!--  >label for="description">Account Frozen</label><br>
		<input type="hidden" name="description" id="description"><br-->
			<input type="submit">
		
	</form>

<%@ include file="footer.jsp" %>