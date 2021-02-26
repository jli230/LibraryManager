<%@ include file="header.jsp" %>

	<h2>Add A Patron:</h2>
	<form method="POST" action="PatronServlet">
	<input type="hidden" name="action" id="action" value="add"><br>
	<label for="firstname">Patron First Name</label><br>
	<input type="text" name="firstname" id="firstname"><br>
		<label for="lastname">Patron Last Name</label><br>
	<input type="text" name="lastname" id="lastname"><br>
	<label for="username">Username</label><br>
	<input type="text" name="username" id="username"><br>
	<label for="password">Password</label><br>
	<input type="password" name="password" id="password"><br>
		<!--  >label for="description">Account Frozen</label><br>
	<input type="hidden" name="description" id="description"><br-->
		<input type="submit">
	
	</form>

<%@ include file="footer.jsp" %>