<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>

<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link href="<c:url value='/resources/css/mainpage.css'></c:url>" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>


<script>
	$(function(){
		$( ".sidemenu" ).accordion();
	});
</script>
<script>
	$(function(){

		$("#modifyform").validate({
            rules: {
            	name: "required",
				officeinfo: "required"
            },	
            messages: {
            		name: "Name can't be null",
                	officeinfo: "Office Information can't be null",
             },
            submitHandler: function(form) {
                form.submit();
           	 }
           
        });

		$("#fileuploadform").validate({
            rules: {
            	filedes: "required",
			},	
            messages: {
            	filedes: "File Description can't be null",
             },
            submitHandler: function(form) {
                form.submit();
           	 }
           
        });
		
	});
	
	</script>
</head>
<body >
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
	<div class="mainbody">
		<div id="sidemenu" class="sidemenu">
			<h3 id="myprofiletitle">My Profile</h3>
			<div id="myprofile"></div>
			<h3>Classes</h3>
			<div id="classdiv"></div>
			<h3>Students</h3>
			<div id="student"></div>
			<h3 id="filetag">Files</h3>
			<div id="myfile">
				<form id="fileuploadform" method="POST" action="uploadfile" enctype="multipart/form-data">
					<span class="text-info"><b>New File :</b></span>
					<span class="btn btn-warning btn-file">
    					Browse <input type="file" name="fileupload" onchange='$("#upload-file-info").html($(this).val());'>
					</span>
					<span class="btn btn-success btn-submit">
						Upload <input type="submit" name="Submit" />
					</span>
					<textarea id="filedes" class="form-control" rows="3" name="filedes" placeholder="File Description" ></textarea>
  				</form>
				<span class='label label-info' id="upload-file-info"></span>
				<ul id="fileul" class='fileul'>
					<li>The Files You Have</li>
				</ul>
			</div>
		</div>
		<div class="workarea">
			<p id="worktitle">WORK AREA</p>
			<div class="modifydiv">
				<form id="modifyform" class="form-horizontal" method="POST" action="modifyprofile">
 		 			<div class="form-group">
    					<input type="text" class="form-control" id="exampleInputEmail3" placeholder="Name" name="name"/>
  					</div>
  					<div class="form-group">
   						<textarea class="form-control" rows="3" name="officeinfo" placeholder="Your Office Information"></textarea>
  					</div>
  					<button  id="save" type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
			<div id="droparea" class="droparea ui-widget-content">
				<ul>
					<li class="placeholder">Drop your file here!</li>
				</ul>
				<button id="fileshare" type="button" class="btn btn-info">Share!</button>
			</div>
 		</div>
	</div>
</body>
<script>
$(function(){

	//delete selected list elements
	$("#droparea ul").delegate("li","click", function(){
		$(this).remove();
	});		

	//fileshare button
	$("#fileshare").on("click",function(){
		$list = $("#droparea ul li");
		console.log($list.length);	
		var a = [];
		for(var i = 0 ; i< $list.length; i++){
				a.push($list[i].innerHTML);
			}
		if($list.length == 0){
				alert("You have to select one file!");
				return false;
			}
		
			$.ajax(
					{
						type:'POST',
						url:"http://localhost:8080/finalproject/fileshare",
						contentType:"application/json",
						data:JSON.stringify(a),
						dataType:'json',
					}
				);
	});
	
	//files information
	$.ajax({
				type:"POST",
				url:"http://localhost:8080/finalproject/populatefile",
				contentType:"application/json;charset=utf-8",
				success:function(data){
					console.log(data);
					var inmyfile = "";
					for(var i=0;i<data.length;i++){
						inmyfile += "<li>" + data[i] + "</li>";
					}
					$(".fileul").append(inmyfile);
				},
				error:function(){
					alert("files can't populate");
				}
			});


	//students info
	var classes = '';
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/finalproject/student",
			contentType:"application/json;charset=utf-8",
			success:function(data){
				console.log(data);
				for(var i=0;i<data.length;i++){
					classes += "<h4>" + data[i].theclass.classname +"</h4>";
						classes += "<ul>";
						for(var j=0; j<data[i].students.length;j++){
							classes += "<li>" + data[i].students[j].name + "</li>";
						}
						classes += "</ul>";
				}
				
				$("#student").html(classes);
			},
			error:function(){
				alert("We can't find the student data!");
			}
	});
	//classes information
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/finalproject/classes",
			contentType:"application/json;charset=utf-8",
			success:function(data){
				var mydiv = "<ul>";
				for(var i=0; i< data.length; i++){
						mydiv += "<li>"+data[i].id+data[i].classname+"</li>";
					}
					mydiv += "</ul>";
					$("#classdiv").html(mydiv);
			},
			error:function(){
				alert("We can't find the student data!");
			}
	});
	
	//teacher profile
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/finalproject/teacher",
		contentType:"application/json;charset=utf-8",
		success:function(data){

			console.log(data);
			var mydiv = "<ul>";
			mydiv += "<li><h4>My Name:</h4>" + data.name + "</li>";
			mydiv += "<li><h4>My Username:</h4>" + data.username + "</li>";
			mydiv += "<li><h4>My Office Information:</h4>" + data.officeinfo + "</li>";
			mydiv += "<button id='modify' class='btn btn-success' type='button'>Modify</button>";
			mydiv += "</ul>";

			$("#myprofile").html(mydiv);
			
		},
		error:function(){
			alert("We can't find the teacher data!");
		}
});
	//modify profile
	$("#myprofile").delegate("#modify","click",function(){
		$(".modifydiv").css("visibility","visible");
		$("#droparea").css("visibility","hidden");
	});
	
	$("#filetag").on("click",function(){
		$(".modifydiv").css("visibility","hidden");
		$("#droparea").css("visibility","visible");

	});
	
	$("#myprofiletitle").on("click",function(){
		$(".modifydiv").css("visibility","hidden");
		$("#droparea").css("visibility","hidden");
	});
	
	//share files
	$(".fileul").delegate("li","click",function(){
						
						$("#myfile li").draggable({
								appendTo:"body",
								helper:"clone"
							});
						
						$( ".droparea ul" ).droppable({
						      activeClass: "ui-state-default",
						      hoverClass: "ui-state-hover",
						      accept: ":not(.ui-sortable-helper)",
						      drop: function( event, ui ) {
						        $( this ).find( ".placeholder" ).remove();
						        $( "<li></li>" ).text( ui.draggable.text() ).appendTo( this );
						      }
						    }).sortable({
						      items: "li:not(.placeholder)",
						      sort: function() {
						        // gets added unintentionally by droppable interacting with sortable
						        // using connectWithSortable fixes this, but doesn't allow you to customize active/hoverClass options
						        $( this ).removeClass( "ui-state-default" );
						      }
						    });
		});
});
</script>

</html>