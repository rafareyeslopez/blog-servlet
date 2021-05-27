<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Add blog</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center align-items-center" style="height:100vh">
        <div class="col-4">
            <div class="card">
                <div class="card-body">
                	<h1>Create Blog</h1>
                    <form action="<%=request.getContextPath()%>/addblog" method="post" class="container">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" id="name" class="form-control" name="name"><br>
                        </div>
                        <div class="form-group">
                            <label for="url">URL:</label>
                            <input type="url" id="url" class="form-control" name="url"><br>
                        </div>
                        <div class="form-group">
                        <label for="categories">Choose the categories:</label>

					<select name="categories" id="categories" multiple>
					  <option value="java">Java</option>
					  <option value="pyhton">Python</option>
					  <option value="docker">Docker</option>
					  <option value="mysql">MySQL</option>
					</select>
					</div>

                        <button type="submit" id="add" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
