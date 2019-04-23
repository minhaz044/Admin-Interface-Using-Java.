<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class=".container-fluid">
<div  class="p-3 mb-2 bg-dark text-white">
<div class="row">
<div class="col-md-10"><span class="">Wellcome to Admin Page. </span></div>
<div class="col-md-2"><span class="mr-3"><%= session.getAttribute("userName")%></span><a href="#">Log Out</a></div>

</div> 


</div>
	 
	<% if(session.getAttribute("message")!=null){%>
	<div class=" <%= session.getAttribute("msgType") %> text-center"> <%= session.getAttribute("message") %></div> 
	<% session.setAttribute("message", null);} %>



	
