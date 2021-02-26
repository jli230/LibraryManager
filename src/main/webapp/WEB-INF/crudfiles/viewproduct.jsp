<%@page import="com.cognixia.jump.model.Product"%>
<%@page import="java.util.List"%>
<%@include file = "header.jsp" %>
	<h2>Products List:</h2>
	<dl>
	<%List<Product> products = (List<Product>) request.getAttribute("products");
	if (products!=null){
		for (Product product: products){
	%>
		<dt><%=product.getItem() %></dt>
		<dd><%=product.getDescription() %></dd>
		<dd>Number Available: <%=product.getQty() %></dd>
	<%	} 
	}
	%>
	</dl>

<%@include file = "footer.jsp" %>