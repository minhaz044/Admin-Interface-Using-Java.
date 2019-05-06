
<jsp:include page="base.jsp" />
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<!-- ------------------------------------------------------->
<div class="row ">
<div class="col-md-3"></div>
<div class="col-md-6">
<%=request.getAttribute("forms") %>
</div>
<div class="col-md-3"></div>
</div>


<!-- ------------------------------------------------------->
	
<jsp:include page="footer.jsp" />