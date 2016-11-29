<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link href="<c:url value='/resources/css/login.css'></c:url>" rel="stylesheet">
	
	<!-- jquery -->
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<script>
	$(function(){

		$("#userloginform").validate({
            rules: {
            	username: "required",
				password: "required"
            },	
            messages: {
            		username: "Please enter your username",
                	password: "Please enter your password",
             },
            submitHandler: function(form) {
                form.submit();
           	 }
           
        });
		
	});
	
	</script>
</head>
<body>

	<form id="userloginform" class="form-horizontal" method="POST" action="userlogin">
 		 <div class="form-group">
    		<label class="sr-only" for="exampleInputEmail3">User Name</label>
    		<input type="text" class="form-control" id="exampleInputEmail3" placeholder="Enter username" name="username">
  		</div>
  		<div class="form-group">
   			<label class="sr-only" for="exampleInputPassword3">Password</label>
    		<input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password" name="password">
  		</div>
  		<div class="checkbox">
    		<label>
     			 <input name="rememberme" type="checkbox" value="remember"> Remember me
    		</label>
  		</div>
  		<button type="submit" class="btn btn-success">Sign in</button>
</form>
<p id="errormessage"><c:out value="${error}"></c:out></p>
</body>
</html>
