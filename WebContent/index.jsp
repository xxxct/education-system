<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>教学管理系统</title>
<link type="text/css" rel="stylesheet" href="css/login.css"/>
</head>
<body class="c2">
	<div id="c4">
		<p>教学管理系统</p>
		
	</div>
	<div id="login">
	 	<div class=c3>
        	<h1>Login</h1>
        </div>  
		<form action="LoginServlet?label=login" method="post">

			<input class="c1" type="text" name="ID" class="txt" placeholder="请输入学号" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/>
			<br>
		
			<input class="c1" type="password" name="password" class="txt" placeholder="请输入密码"/>
			<br>
			<input type="radio" name="type" value="S" id="S" checked><label class="c0" for="S" >学生</label>
			<input type="radio" name="type" value="T" id="T"><label class="c0" for="T">教师</label>
		<br>
			<br>
			<input class="but" type="submit" value="登录" class="btn"/>	
		</form>
	</div>
	<div>
		<%
		String error=(String)request.getAttribute("error");
		if("E".equals(error)){
			out.println("登陆失败！ID或密码错误");
			
		}
		%>
	</div>

</body>
</html>