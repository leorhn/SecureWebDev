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
		<div class="containter-center">
		
		</div>
		
		<div class= "col-lg-7 center">
			<h3 class="">Meeting Room Reservation</h3>	
			<table class="table table-sm">
				<tr>
					<th>Time Slots</th>
				</tr>
				<tr>
					<td>Room 1</td>
				</tr>
				<tr>
					<td>Room 2</td>
				</tr>
				<tr>
					<td>Room 3</td>
				</tr>
				<tr>
					<td>Room 4</td>
				</tr>
				<tr>
					<td>Room 5</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>