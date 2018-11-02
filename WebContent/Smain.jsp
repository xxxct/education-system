<%@page import="vo.Login"%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生界面</title>
<link rel="stylesheet" href="css/bg.css">
</head>
<body>
<%-- <%Login login=(Login)request.getSession().getAttribute("USER"); %> --%>


	<div class="c1">
			
	</div>
	<div class="c2">
		<div class="c3">
			<div class="c5">
				<div class="c6">
    			</div>
    		</div>
    		<div class="c7">
    			主菜单
    		</div>
    		<div class="c8">
    			<div class="c9">
    				学生
    			</div>
    			<div class="c10">
    				<ul>
    					<li><a class="c11" href="TakesServlet?type=listcourse">课程查询</a></li>
    					<li><a class="c11" href="TakesServlet?type=grademanage">成绩查询</a></li>
    					<li><a class="c11" href="LoginServlet?label=listStudent">个人信息</a></li>
    					<li><a class="c11" href="LoginServlet?label=logout">注销</a></li>
    				</ul>
    			</div>
    		</div>
		</div>	
		<div class="c4">
			<div class="c12">
				<%
					if(request.getAttribute("studentList")!=null){
				%>
					<div>
						<table border="1px">
							<tr><th>学号</th><th>姓名</th><th>学院</th></tr>
							<%=request.getAttribute("studentList") %>
						</table>
					</div>
				<%
					}
				%>
				<%
					if(request.getAttribute("courseList")!=null){
				%>
					<div>
						<table border="1px">
							<tr><th>课程名</th><th>授课老师</th><th>教学楼</th><th>教室</th><th>学年</th><th>学期</th><th>学分</th></tr>
							<%=request.getAttribute("courseList") %>
						</table>
					</div>
				<%
					}
				%>
				<%
					if(request.getAttribute("gradeList")!=null){
				%>
					<div>
						<table border="1px">
							<tr><th>课程名</th><th>学年</th><th>学期</th><th>学分</th><th>成绩</th></tr>
							<%=request.getAttribute("gradeList") %>
						</table>
					</div>
				<%
					}
				%>
    		</div>
    	</div>
    </div>
	<script>
	    var days = ['零','一','二','三','四','五','六','七','八','九','十'];
	    var oData = new Date();
	    var str = ''+oData.getFullYear()+'年'+tab(oData.getMonth()+1)+'月'+tab(oData.getDate())+'日';
	    var oDiv = document.getElementsByClassName('c6')[0];
	    var sLast = '';
	    for(var i=0;i<str.length;i++)
	    {
	        if(isNaN(parseInt(str.charAt(i))))
	        {
	            if(str.charAt(i) == '-')
	           {
	               sLast += days[days.length-1];
	           }else {
	              sLast += str.charAt(i);
	           }
	 
	        }else{
	          sLast += days[str.charAt(i)];
	        }
	     }
	     oDiv.innerHTML = sLast;
	 
	    function tab(num)
	    {
	        return num<10 ? ''+num : parseInt(num.toString().charAt(1)) == 0 ? num.toString().charAt(0)+'-' : num.toString().charAt(0)+'-'+num.toString().charAt(1);
	    }
	</script>
</body>
</html>