<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet" href='<c:url value="/resources/css/community.css"></c:url>'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="navdiv">
		<nav id="nav" class="navbar navbar-default">
			<ul class="nav navbar-nav">
				<li><a href='<c:url value="homepage"></c:url>'>Home</a></li>
				<li class="active"><a href='<c:url value="admin"></c:url>'>File System</a></li>
				<li><a href='<c:url value="community"></c:url>'>Community</a></li>
				<li><a href="<c:url value='logout'></c:url>" class="navbar-link navbar-right">Log out</a></li>
			</ul>
		</nav>
	</div>
	<div id="container">
	</div>
</body>
<script>
	$(function(){
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/finalproject/filediv",
			contentType:"application/json;charset=utf-8",
			success:function(data){
				console.log(data);
				for(var j=0;j<data.length;j++){
					var userdiv = "<table id='user' class='table table-hover'>";
					userdiv += "<tr><th class='name'>"+data[j].name+"</th></tr>";
					userdiv += "<tr><th>Upload Date</th><th>File Name</th><th>Description</th><th>Get File</th></tr>"
					console.log(data[j].dates);
					for(var i=0;i<data[j].dates.length;i++){
							userdiv += "<tr>";
							userdiv += "<td>"+ data[j].dates[i]+"</td>";
							userdiv += "<td>"+ data[j].filetables[i].fileName+"</td>";
							userdiv += "<td>"+ data[j].filetables[i].des+"</td>";
							userdiv += "<td><form action='download' method='post'><input name='filename' value='"+data[j].filetables[i].fileName+"' type='hidden'><button type='submit' class='btn btn-info'>download</button></form></td>";
							userdiv += "</tr>";
					}
					userdiv += "</table>";
					
					}
				
				$("#container").append(userdiv);
			},
			error:function(){
				alert("files can't populate");
			}
		});

		$("#container").delegate("button","click",function(){
			console.log("hello");
		});
	});
</script>
</html>