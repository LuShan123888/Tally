<%@ page import="com.example.bean.User" %>
<%@ page import="java.util.Enumeration" %>
Created by IntelliJ IDEA.
User: Cian
Date: 2020/4/25
Time: 20:36
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Enumeration<String> parameters = request.getParameterNames();
    String pname;
    while (parameters.hasMoreElements()) {
        pname = parameters.nextElement();
        out.println(pname + " : " + request.getParameter(pname) + "<br>");
    }
    out.println("<br><br><br>");
    Enumeration<String> Attributes = request.getAttributeNames();
    String Aname;
    while (Attributes.hasMoreElements()) {
        Aname = Attributes.nextElement();
        out.println(Aname + " : " + request.getAttribute(Aname) + "<br>");
    }
    if (request.getSession().getAttribute("user") != null) {
        User user = (User) request.getSession().getAttribute("user");
        out.println(user.getUsername());
    }

%>
</body>
</html>
