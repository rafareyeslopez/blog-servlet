<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="/js/functions.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/Style.css">
</head>
<body>




<jsp:include page="header.jsp"/>
<h1 align="center"><span>Hey <c:out value="${not empty sessionScope.useremail ? sessionScope.useremail : 'Guest'}"/>, welcome </span></h1>


<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">URL</th>
      <th scope="col">Categories</th>
      <c:if test="${not empty sessionScope.useremail}">
	  	<th scope="col">actions</th>      
	  </c:if>
    </tr>
  </thead>
  <tbody>



<c:forEach var="b" items="${blogs}">

    <tr>
      <th scope="row">
      	<a href="<%=request.getContextPath()%>/viewBlogDetail?blogId=${b.id }">
	      ${b.id }
	    </a>
      </th>
      <td> ${b.name }</td>
      <td>${b.url }</td>
      <td>
      <c:forEach items="${b.categories}" var="item">
    	${item} <br/>
</c:forEach>
      
      
      </td>
      <c:if test="${not empty sessionScope.useremail && b.userEmail==sessionScope.useremail}">
         <td>
              <a href="<%=request.getContextPath()%>/jsp/addpost.jsp?blogId=${b.id }"> <button type="button" class="btn btn-primary"><i class="far fa-eye">Add Post</i></button></a>
              <a href="<%=request.getContextPath()%>/viewBlogDetail?blogId=${b.id }"> <button type="button" class="btn btn-success"><i class="fas fa-edit"></i>View</button></a>
            </td> 
      </c:if>
    </tr>
         
</c:forEach>

  </tbody>
  
    <c:if test="${not empty sessionScope.useremail}">
    <tfoot>
    <tr>
      <td>
	<a href="<%=request.getContextPath()%>/jsp/addblog.jsp">
	<button type="button" class="btn btn-info">Add Blog
	</button></a>
	</td>
  </tfoot>
  </c:if>
</table>

</body>
</html>
