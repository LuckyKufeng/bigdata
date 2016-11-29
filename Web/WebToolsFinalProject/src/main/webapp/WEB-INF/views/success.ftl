<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style>
body{
	background-image:url("/finalproject/resources/img/bgimg.jpg");
	background-attachment: fixed;
}
#nav{
	width:80%;
	margin-left: 10%;
	margin-top: 50px;
}
	p{
	font-weight:80px;
	color: white;
	font-size:50px;
}

div{
	width:100%;
	height:200px;
	margin-top: 200px;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
	<nav id="nav" class="navbar navbar-default navbar-fixed-top">
		<ul class="nav navbar-nav">
			<li><a href='/finalproject/homepage'>Home</a></li>
            <li><a href='/finalproject/admin'>File System</a></li>
            <li><a href='/finalproject/community'>Community</a></li>
        </ul>
	</nav>
	<div>
		<p>${name}</p>
	</div>
</body>
</html>