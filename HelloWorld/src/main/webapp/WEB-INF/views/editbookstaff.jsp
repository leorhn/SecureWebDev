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
	  	  <a class="navbar-brand">Library - Staff</a>
	  	</div>
			<ul class="nav navbar-nav">
		  <li><a href="default.asp">Home</a></li>
		  <li><a href="news.asp">Staff</a></li>
		  <li><a href="news.asp">Meeting Rooms</a></li>
		  <li><a href="">Edit Books</a></li>
		  <li><a href="contact.asp">Logout</a></li>
		  	</ul>
	  </div>
	</nav>
	<div class="container-fluid">
		<form>
			<div class= "col-lg-5 center">
				<table class="table table-hover">
					<tr>	
						<td class="col-lg-1">
							Author
						</td>
						<td>
						  <div class="form-group">
						      <input type="text" class="form-control" id="inputAuthor" placeholder="Author">
						  </div>
						</td>	
					</tr>
					<tr>	
						<td class="col-lg-1">
							Title
						</td>
						<td>
						  <div class="form-group">
						      <input type="text" class="form-control" id="inputTitle" placeholder="Title">
						  </div>
						</td>			
					</tr>
					<tr>
						<td class="col-lg-1">
							Location
						</td>
						<td>
						  <div class="form-group">
						      <input type="text" class="form-control" id="inputLocation" placeholder="Location">
						  </div>
						</td>	
					</tr>
					<tr>		
						<td class="col-lg-1">
							Year
						</td>
						<td>
						  <div class="form-group">
						      <input type="text" class="form-control" id="inputYear" placeholder="Year">
						  </div>
						</td>	
					</tr>
					<tr>	
						<td class="col-lg-1">
							Publisher
						</td>
						<td>
						  <div class="form-group">
						      <input type="text" class="form-control" id="inputPublisher" placeholder="Publisher">
						  </div>
						</td>	
					</tr>
					<tr>	
						<td class="col-lg-1">
							Tags
						</td>
						<td>
						  <div class="form-group">
						      <input type="text" class="form-control" id="inputTags" placeholder="Tag1, Tag2, Tag3">
						  </div>
						</td>	
					</tr>
				</table>
				<div class="form-group center">
		    	<div class="col-lg-1">
		      <button type="submit" class="btn btn-primary">Save Changes</button>
		    	</div>
			</div>
		  	</div>
		</form>
	</div>
	
</body>
</html>