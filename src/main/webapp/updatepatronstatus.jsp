<%@ include file="header.jsp" %>

	<h2>Update A Patron:</h2>
	<form method="POST" action="PatronServlet">
		<label for="patron_id">Patron ID</label><br>
	<input type="hidden" name="action" id="action" value="unfreeze"><br>
	<input type="number" name="patron_id" id="patron_id"><br>
	<label for="account_frozen">Account Frozen?</label><br>
	<input type="checkbox" checked name="decision" id="decision">
		<input type="submit">
	
	</form>

<%@ include file="footer.jsp" %>