<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Log in</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	
	<div class="container">
		<div class="row justify-content-center align-items-center"
			style="height: 100vh">
			<div class="col-4">
			
				<div class="card">
					<div class="card-body">
					<h1>Login</h1>
						<c:if test="${not empty message}">
							<div class="alert alert-secondary" role="alert">${message}
							</div>
						</c:if>
						<form action="<%=request.getContextPath()%>/login" method="post">
							<div class="form-group">
								<label for="email">User:</label> <input type="email" id="email"
									class="form-control" name="email">
							</div>
							<div class="form-group">
								<label for="password">Password:</label> <input type="password"
									id="password" class="form-control" name="password">
							</div>
							<button type="submit" id="submit" class="btn btn-primary">Submit</button>
							<a href="<%=request.getContextPath()%>/jsp/register.jsp">
								<button type="button" class="btn btn-info">Register
									here</button>
							</a> <a href="<%=request.getContextPath()%>/viewBlogs">
								<button type="button" class="btn btn-info">View Blogs</button>
							</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
