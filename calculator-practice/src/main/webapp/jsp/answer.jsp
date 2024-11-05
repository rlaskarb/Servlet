<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 11. 5.
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Integer result = Integer.parseInt((String)request.getAttribute("result"));
    System.out.println("result = " + result);
    String msg = (String) request.getAttribute("msg");
%>

<div><%=result%></div>
<div><%=msg%></div>

<a href="/index.jsp">다시계산하기</a>


</body>
</html>
