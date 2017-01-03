<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 -->
 <!DOCTYPE html> 
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<meta http-equiv=Content-Type content=text/html; charset=UTF-8>
<script src=https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js></script>
<link rel=stylesheet href=https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/cupertino/jquery-ui.css>
<script src=https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js></script>
<script type=text/javascript src=script/MyScript.js></script>

<title>Business day</title>
</head>

<body>
<h2>Business day calculation</h2>

<form action=BusinessDayServlet method=post>
Start day<input type=text name=startDate id=startDate><p>
End day  <input type=text name=endDate id=endDate><p>

<input type=submit value=submit>
<input type=reset value=reset>
</form>


</body>
</html>