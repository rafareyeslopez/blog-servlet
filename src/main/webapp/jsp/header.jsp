<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<div class="container">
	<div class="row justify-content-left">
		<div class="col">
			<a href="<%=request.getContextPath()%>/viewBlogs"> 
			
			<button type="button" class="btn btn-primary">
                <svg xmlns="http://www.w3.org/2000/svg" width="36" height="16" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"></path>
  <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"></path>
</svg>
                Home
              </button>
			</a>	
			
		</div>
		<div class="col">
			<c:out value="${not empty sessionScope.useremail ? sessionScope.useremail : 'Guest'}"/>
		</div>
		
		<c:if test="${not empty sessionScope.useremail}">
		<div class="col">
			<a href="<%=request.getContextPath()%>/logout"> 
			
		<button type="button" class="btn btn-primary">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-door-closed" viewBox="0 0 16 16">
  <path d="M3 2a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1v13h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V2zm1 13h8V2H4v13z"></path>
  <path d="M9 9a1 1 0 1 0 2 0 1 1 0 0 0-2 0z"></path>
</svg>
                Log out
              </button>
			</a>	
			
		</div>
		</c:if>
		<c:if test="${empty sessionScope.useremail}">
		<div class="col">
			<a href="<%=request.getContextPath()%>/index.jsp"> 
			
			<button type="button" class="btn btn-primary">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-door-open" viewBox="0 0 16 16">
  <path d="M8.5 10c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"></path>
  <path d="M10.828.122A.5.5 0 0 1 11 .5V1h.5A1.5 1.5 0 0 1 13 2.5V15h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V1.5a.5.5 0 0 1 .43-.495l7-1a.5.5 0 0 1 .398.117zM11.5 2H11v13h1V2.5a.5.5 0 0 0-.5-.5zM4 1.934V15h6V1.077l-6 .857z"></path>
</svg>
                Log in
              </button>
			</a>	
			
		</div>
		</c:if>
		
		
	</div>
</div>