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
		<h1 class="text-justified">Register</h1>
	
		<form class="form-horizontal">
		  <div class="form-group">
		    <label for="inputFirstName" class="col-sm-2 control-label">First Name</label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" id="inputFirstName" placeholder="First Name">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputMiddleInitial" class="col-sm-2 control-label">Middle Initial</label>
		    <div class="col-sm-1">
		      <input type="text" class="form-control" id="inputMiddleInitial" placeholder="M.I.">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputLastName" class="col-sm-2 control-label">Last Name</label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" id="inputLastName" placeholder="Last Name">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputUsername" class="col-sm-2 control-label">Username</label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" id="inputUserName" placeholder="Username">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-3">
		      <input type="email" class="form-control" id="inputEmail3" placeholder="email@domain.com">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
		    <div class="col-sm-4">
		      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputID" class="col-sm-2 control-label">Student/Faculty ID</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="inputID" placeholder="12345678">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputBirthday" class="col-sm-2 control-label">Birthday</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="inputFirstName" placeholder="DD/MM/YYYY">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputQA" class="col-sm-2 control-label">Secret Question</label>
		    <div class="col-sm-5">
				<div class="dropdown">
				  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				    Secret Question
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="#">Q1</a></li>
				    <li><a href="#">Q2</a></li>
				    <li><a href="#">Q3</a></li>
				  </ul>
				</div>
				<input type="text" class="form-control" id="inputSecretAnswer" placeholder="Secret Answer">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Register</button>
		    </div>
		  </div>
		</form>
	</div>
</body>
</html>