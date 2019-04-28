<jsp:include page="base.jsp" />

<!-- ------------------------------------------------------->
<div class="row ">
<div class="col-md-3"></div>
<div class="col-md-6">
<form class="mt-5"action="/delete.jsp" method="POST">
  <div class="form-group">
    <label for="email">Do You want to delete this?</label>
    <input type="hidden" class="form-control" id="name" name="name" value="${tableName }" >
    <input type="hidden" class="form-control" id="id" name="id" value="${id }" >
  </div>
   <a class="btn btn-info mr-5" href="/homepage.jsp?id=${tableName}">Cancel</a>
  <button type="submit" class="btn btn-danger">Delete</button>
</form>
</div>
<div class="col-md-3"></div>
</div>




<!-- ------------------------------------------------------->	
<jsp:include page="footer.jsp" />