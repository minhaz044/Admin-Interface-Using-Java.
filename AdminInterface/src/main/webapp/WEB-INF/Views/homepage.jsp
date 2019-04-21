<%@page import="java.sql.ResultSet"%>
<jsp:include page="base.jsp" />

<!-- ------------------------------------------------------->



	<div class="row ">
	<div class="col-md-2">
	<div class="m-3 text-center">
	<p class="border-bottom m-3">Table Name</p>
	<%
	ResultSet resultIndex=(ResultSet)request.getAttribute("index");
	int i=0;
	while(resultIndex.next()){
%>
	<p class="border-right border-bottom bg-success ">
	<a class="text-white" href='#'><%= resultIndex.getString("name").substring(0, 1).toUpperCase() + resultIndex.getString("name").substring(1) %></a>
	 </p>	
<% 		
	}
%>

	</div>
	</div>
	<span class="border-right"></span>
	<span class="border-right"></span>
	
	<div class="col-md-8">
		<table class="table">
  	<tbody>
	<%
	ResultSet resultData=(ResultSet)request.getAttribute("data");
	while(resultData.next()){
	%>
 
    
  	
	
   		<tr>
      <td><%= resultData.getString("userName") %></td>
      <td><a class="btn btn-success">Update</a></td>
      <td><a class="btn btn-danger">Delete</a></td>
        </tr>
    <%} %> 
  
  </tbody>
</table>
	<p>

	
	
	
	</div>
	</div>







<!-- ------------------------------------------------------->
	
<jsp:include page="footer.jsp" />