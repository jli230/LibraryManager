<%@page import="com.cognixia.jump.dao.PatronDAOClass"%>
<%@page import="com.cognixia.jump.model.Patron"%>
<%@page import="java.util.List"%>

<%@ include file="header.jsp" %>

	<h2>Patrons List:</h2>

	<% PatronDAOClass patronDAO = new PatronDAOClass();
	
	List<Patron> patronList = patronDAO.getAllPatrons();
	
	for (Patron patron : patronList){
	%>

	<dl>


		<dt>User ID #<%=patron.getId() %></dt>
		<dd>First Name: <%=patron.getFirst_name() %></dd>
		<dd>Last Name: <%=patron.getLast_name() %></dd>
		<dd>Username: <%=patron.getUsername() %></dd>
		<dd>Password <%=patron.getPassword() %></dd>
		<dd>
			Account Frozen: <%=patron.isAccount_frozen() %>
			
			<% 
			if(patron.isAccount_frozen() == true){
				//patron.setAccount_frozen(false);
			%>
				<form method="POST" action="PatronServlet">
				<input type="hidden" name="action" id="action" value="unfreeze"><br>
					<label for="patronid"></label>
					<input type="hidden" name="patron_id" 
						id="patron_id" value="<%=patron.getId() %>">
					<input type="submit" value="Unfreeze User?">
				</form>
			<%		
			}
			%>
		</dd>
		
		<%	
		}
		%>

	</dl>

<%@ include file="footer.jsp" %>