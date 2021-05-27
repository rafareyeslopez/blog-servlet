<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page session="true"%>
<html>
<head>
<title>Blog</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="/js/functions.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/Style.css">
</head>
<body>

	<jsp:include page="header.jsp" />
	<h1 align="center">
		<span>${blog.name}</span>
	</h1>

	<c:forEach var="post" items="${blog.posts}">

		<h2 align="center">${post.title }</h2>

		<div class="container">


			<div class="row">
				<div class="col">${post.content }</div>
			</div>
			<c:if test="${(not empty post.attachmentPath)}">
			<div class="row">
				<div class="col">
				<a href="<%=request.getContextPath()%>/downloadfile?postId=${post.id}">Download attachment</a></div>
			</div>
			</c:if>
			<div class="row">
				<div class="col">Created at: <fmt:formatDate type = "both" value = "${post.createdAt }" />, Updated at
					<fmt:formatDate type = "both" value = "${post.updatedAt }" /></div>
				<c:if test="${(not empty sessionScope.useremail) && (blog.userEmail==sessionScope.useremail || sessionScope.useremail=='root')}">
					<div class="col">
						<a
							href="<%=request.getContextPath()%>/editpost?postId=${post.id }&blogId=${ post.blogId}">
							<button type="button" class="btn btn-primary">
								<i class="far fa-eye">Edit</i>
							</button>
						</a>
						<a
							href="<%=request.getContextPath()%>/jsp/addattachment.jsp?postId=${post.id }&blogId=${ post.blogId}">
						 <button type="button" class="btn btn-success">
							<i class="fas fa-edit"Upload file>Upload attachment</i>
						</button> 
						</a>
						<a
							href="<%=request.getContextPath()%>/deletepost?postId=${post.id}&blogId=${ post.blogId}">
							<button type="button" class="btn btn-danger">
								<i class="far fa-trash-alt">Delete</i>
							</button>
						</a>
					</div>
				</c:if>

			</div>
			<h3>Comments:</h3>
			<c:if
				test="${(not empty sessionScope.useremail) && (blog.userEmail==sessionScope.useremail || sessionScope.useremail=='root')}">



				<c:forEach var="comment" items="${post.comments}">


					<div class="row">
						<div class="col">${comment.userEmail }-<fmt:formatDate type = "both" value = "${comment.createdAt }" /></div>
					</div>
					<div class="row">
						<div class="col">${comment.content }</div>
					</div>
					<div class="row">
						<div class="col">
							<c:out
								value="${ comment.published ? 'Published' : 'Unpublished'}" />
						</div>
					<div class="col">
						<a
							href="<%=request.getContextPath()%>/publishcomment?commentId=${comment.id }&blogId=${ post.blogId}">
							<button type="button" class="btn btn-primary">
								<i class="far fa-eye">Publish</i>
							</button>
						</a>
						<a
							href="<%=request.getContextPath()%>/deletecomment?commentId=${comment.id }&blogId=${ post.blogId}">
							<button type="button" class="btn btn-danger">
								<i class="far fa-trash-alt">Delete</i>
							</button>
						</a>
					</div>
					</div>

				</c:forEach>
			</c:if>

			<c:if
				test="${empty sessionScope.useremail || (blog.userEmail!=sessionScope.useremail &&  sessionScope.useremail!='root')}">
				<c:forEach var="comment" items="${post.comments}">
					<c:if test="${comment.published}">
						<div class="row">
							<div class="col">${comment.userEmail }-<fmt:formatDate type = "both" value = "${comment.createdAt }" /></div>
						</div>
						<div class="row">
							<div class="col">${comment.content }</div>
						</div>
					</c:if>
				</c:forEach>
			</c:if>
			
					<div class="row">
			<div class="col">
				<a
					href="<%=request.getContextPath()%>/jsp/comment.jsp?postId=${post.id }&blogId=${post.blogId }&user=${sessionScope.useremail}">
					<button type="button" class="btn btn-success">
						<i class="fas fa-edit">Comment</i>
					</button>
				</a>
			</div>
		</div>
			
			
		</div>



	</c:forEach>



</body>
</html>
