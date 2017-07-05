<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- First include jquery js -->
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<style>
.top-buffer {
 margin-top:20px; 
 }
 
.center {
float: none;
margin: 0 auto;

}

</style>
</head>
<body>
  
	<nav class="navbar navbar-default navbar-static-top">
	  <div class="containter-fluid">
	  	<div class="navbar-header">
	  	  <a class="navbar-brand">Library - Administrator</a>
	  	</div>
			<ul class="nav navbar-nav">
		  <li><a href="homepage.jsp">Home</a></li>
		  <li><a href="news.asp">Administrator</a></li>
		  <li><a href="news.asp">Meeting Rooms</a></li>
		  <li><a href="news.asp">Assign Account</a></li>
		  <li><a href="contact.asp">Logout</a></li>
		  	</ul>
	  </div>
	</nav>
	
	<div class="container center">
		<form class="form-inline">
			<div class="form-group">
   				<div class="dropdown">
				  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				    Type
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="#">Book</a></li>
				    <li><a href="#">Magazine</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">Any</a></li>
				  </ul>
			  </div>
			</div>
 			  <div class="form-group">
				   <label class="sr-only" for="search">Search</label>
				   <input type="text" class="form-control" placeholder="Search for...">
				<button type="submit" class="btn btn-default">Search</button>							
			</div>
		</form>
	</div>
	<div class="container-fluid top-buffer">
		<div class= "col-lg-8">
			<table class="table table-hover">
				<tr>
					<td class="col-lg-2">
						<button type="button" class="btn btn-default btn-sm">
		 					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add to Cart
						</button>
					</td>
					<td>
						<a href="#">Title</a>
						<p>Author FN, LN</p>
						<p>YEAR</p>
						<p>Location</p>
						<p>Rating</p>
						<p>Status</p>
					</td>
				</tr>
				<tr>
					<td class="col-lg-2">
						<button type="button" class="btn btn-default btn-sm">
		 					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add to Cart
						</button>
					</td>
					<td>
						<a href="#">Title</a>
						<p>Author FN, LN</p>
						<p>YEAR</p>
						<p>Location</p>
						<p>Rating</p>
						<p>Status</p>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>