<%@page import="com.cognixia.jump.dao.BookDAOClass"%>
<%@page import="com.cognixia.jump.model.Book"%>
<%@page import="java.util.List"%>

<%@ include file="header.jsp" %>

<br>
books to be listed here
<br>

	<% BookDAOClass bookDAO = new BookDAOClass();
	
	List<Book> bookList = bookDAO.getAllBooks();
	
	for (Book book : bookList){
	%>

		<dl>
			<dt>ISBN: <%=book.getIsbn() %></dt>
			<dd>Title: <%=book.getTitle() %></dd>
			<dd>Description: <%=book.getDescription() %></dd>
			<dd>Rented: <%=book.isRented() %></dd>
			<dd>Added to Library Date: <%=book.getAdded_to_library() %></dd>
		</dl>

	<%	
	}
	%>
	
<%@ include file="footer.jsp" %>