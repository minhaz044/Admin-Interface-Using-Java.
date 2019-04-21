<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Wellcome to Login Page</title>


</head>
<body>
<div class="container">
	<div class="row ">
		<div class="col-md-4"></div>
		<div class="col-md-4 ">
		<div class="mt-5">
				
			<form action="login.jsp" method="POST">
		  	<div class="form-group">
		    <label for="email">User Id:</label>
		    <input type="text" class="form-control" name="uname" >
		  	</div>
		  	<div class="form-group">
		    <label for="pwd">Password:</label>
		    <input type="password" class="form-control" name="pwd">
		  	</div>
		  	<button type="submit" class="btn btn-success">Submit</button>
			</form>	
		</div>
	


		
			
		

		</div>

	</div>
</div>

</body>
