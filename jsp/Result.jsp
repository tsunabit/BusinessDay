<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>

<body>
<h2>Input</h2>
開始日：
<%=request.getParameter("startDate") %><p>
終了日：
<%=request.getParameter("endDate") %><p>

<h2>Result</h2>
稼働日数：
<%=request.getAttribute("dayDiff").toString() + "日" %><p>
稼働時間： 
<%=request.getAttribute("totalOperatingTime").toString() + "時間" %><p>

<h2>Skip</h2>
<%
ArrayList<String> arrayWkd = (ArrayList<String>)request.getAttribute("arrayWkd");
String skip = "";
for(Iterator<String> iter = arrayWkd.iterator(); iter.hasNext(); ){
    out.println("<font color=\"red\">" + iter.next() + "<font><br>");
}
%>

</body>
</html>