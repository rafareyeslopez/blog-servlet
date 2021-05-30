<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="true" %>
<html>
<head>
    <title>Add attachment</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center align-items-center" style="height:100vh">
        <div class="col-4">
            <div class="card">
                <div class="card-body">
                	<h1>Add attachment</h1>
                	<form method="post" action="<%=request.getContextPath()%>/uploadfile" enctype="multipart/form-data" class="container">
                        <div class="form-group">
                            <label for="content">Choose a file:</label>
                            <input type="file" name="multiPartServlet"/>
                            <!-- <input type="submit" value="Upload"/>  -->
                        
<input type="hidden" name="blogId" value="<%= request.getParameter("blogId") %>">
                        <input type="hidden" name="postId" value="<%= request.getParameter("postId") %>">

                        <button type="submit" id="add" class="btn btn-primary">Upload</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>






