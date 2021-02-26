<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="card" style="width: 18rem;">
		 <div class="card-body">
		   <h5 class="card-title">Login Page</h5>
		   <h6 class="card-subtitle mb-2 text-muted">Welcome! please log in below</h6>
			 
			 <form method="POST" action="LoginServlet">
			 
			  <div class="mb-3">
			    <label for="username" class="form-label">Username:</label>
			    <input type="text" class="form-control" id="username" name="user" >
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Password:</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" name = "userpassword"> 
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		  </div>
	</div>
	
	<div>
		Don't have an account? Sign up for one <a href="<%= request.getContextPath()%>/addpatrons.jsp">here</a>!
	
	</div>
	
	
</body>
</html>