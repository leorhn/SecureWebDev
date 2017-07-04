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

</head>
<body>
  
	<nav class="navbar navbar-default navbar-static-top">
	  <div class="containter-fluid">
	  	<div class="navbar-header">
	  	  <a class="navbar-brand">Library</a>
	  	</div>
			<ul class="nav navbar-nav">
		  <li><a href="default.asp">Home</a></li>
		  <li><a href="news.asp">User</a></li>
		  <li><a href="news.asp">Meeting Rooms</a></li>
		  <li><a href="contact.asp">About</a></li>
		  	</ul>
	  </div>
	</nav>
	<div class="container-fluid">
		<div class= "col-lg-5">
			<table class="table table-hover">
				<tr>	
					<td class="col-lg-1">
						Author
					</td>
					<td>
						<p>Author</p>
					</td>	
				</tr>
				<tr>	
					<td class="col-lg-1">
						Title
					</td>
					<td class="col-lg-1">
						<p>Title</p>
					</td>				
				</tr>				
				<tr>	
					<td class="col-lg-1">
						Status
					</td>
					<td>
						<p>Status</p>
						<button type="button" class="btn btn-primary btn-sm">
		 					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add to Cart
						</button>
					</td>	
				</tr>	
				<tr>	
					<td class="col-lg-1">
						Dates
					</td>
					<td>
						<p>Dates</p>
						<p>Dates</p>
						<p>Dates</p>
					</td>	
				</tr>	
				<tr>	
					<td class="col-lg-1">
						Year
					</td>
					<td>
						<p>Year</p>
					</td>	
				</tr>
				<tr>	
					<td class="col-lg-1">
						Publisher
					</td>
					<td>
						<p>Publisher</p>
					</td>	
				</tr>
				<tr>	
					<td class="col-lg-1">
						Tags
					</td>
					<td>
						<p>Tags</p>
						<p>Tags</p>
						<p>Tags</p>
					</td>	
				</tr>	
			
			</table>
		</div>
	</div>
	
	<div class="container-fluid">	
		<form class="col-lg-4">
							<label for="title">Leave a review</label>
		
		
			<div class="form-group">
				<textarea class="form-control" rows="4"></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form>
	</div>
	
	
	<div class="container-fluid">		
		<div class="list-group col-lg-5">		
				<div class="panel panel-default list-group-item">
					<div class="panel-heading">User name</div>
					<div class="panel-body">
					  Review
					</div>
			</div>
				<div class="panel panel-default list-group-item">
					<div class="panel-heading">User name</div>
					<div class="panel-body">
					  Review
					</div>
			</div>
		</div>		
	</div>
</body>
</html>