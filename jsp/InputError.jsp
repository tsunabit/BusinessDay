<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input Error</title>
</head>

<body>
<h2 style="color: red">Input Error</h2>

<%
String errorMsg = "";
//String errorMsg = request.getAttribute("Input").toString();
if ((request.getAttribute("InputError").toString()).equals("Start")) {
	errorMsg = "開始日エラーです。入力を確認してください。";
}else if((request.getAttribute("InputError").toString()).equals("End")) {
	errorMsg = "終了日エラーです。入力を確認してください。";
}else {
	errorMsg = "整合性エラーです。開始日、終了日の入力の妥当性を確認してください。";
}
%>

<dev style="color: red">
<%= errorMsg %>
</dev>


</body>

</html>