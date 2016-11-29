<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href='<c:url value="/resources/css/homepage.css"></c:url>' rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
	<nav id="nav" class="navbar navbar-default navbar-fixed-top">
		<ul class="nav navbar-nav">
			<li class="active"><a href='<c:url value="homepage"></c:url>'>Home</a></li>
            <li><a href='<c:url value="admin"></c:url>'>File System</a></li>
            <li><a href='<c:url value="community"></c:url>'>Community</a></li>
            <li><a href="<c:url value='logout'></c:url>" class="navbar-link navbar-right">Log out</a></li>
		</ul>
	</nav>
	<video autoplay loop id="bgvid">
		<source src="<c:url value="/resources/img/winer.mp4"></c:url>" type="video/mp4">
	</video>
	<div id="intro">
		<div id="inside">
			<span>Welcome to my file system!</span></br>
			<span>You can download files and upload files here!</span>
		</div>
	</div>
</body>
</html>