<%-- 
    Document   : userdashboard
    Created on : May 21, 2015, 9:18:43 AM
    Author     : Ted Ian Osias
--%>

<%@page import="AES.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            User temp = (User) session.getAttribute("user");
        
        %>
        <title><%=temp.getUsername()%>(Trainee) Dashboard</title>
    </head>
    <body>
        <h1>Welcome <%=temp.getUsername()%> to your dashboard, </h1>
    </body>
</html>
