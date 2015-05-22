<%-- 
    Document   : trainerdashboard
    Created on : May 21, 2015, 9:19:45 AM
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
        <title><%=temp.getUsername()%>(Trainer) Dashboard</title>
    </head>
    <body>
        <h1>Welcome <%=temp.getUsername()%> to your dashboard, </h1>
    </body>
</html>
