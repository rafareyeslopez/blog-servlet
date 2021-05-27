<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Add comment</title>
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
                <h1>Create comment</h1>
                    <form action="<%=request.getContextPath()%>/addcomment" method="post" class="container">
                        <div class="form-group">
                            <label for="content">your comment:</label>
                            <input type="textarea" id="content" class="form-control" name="content"><br>
                        </div>
                        
                        <input type="hidden" name="blogId" value="<%= request.getParameter("blogId") %>">
                        <input type="hidden" name="postId" value="<%= request.getParameter("postId") %>">
                        <input type="hidden" name="user" value="<%= request.getParameter("user") %>">

                        <button type="submit" id="add" class="btn btn-primary">Add comment</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
