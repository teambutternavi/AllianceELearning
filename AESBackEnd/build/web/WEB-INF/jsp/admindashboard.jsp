<%-- 
    Document   : admindashboard
    Created on : May 21, 2015, 9:19:00 AM
    Author     : Ted Ian Osias
--%>

<%@page import="AES.Utility.UserControlListener"%>
<%@page import="AES.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%
            User temp = (User) session.getAttribute("user");
            
        %>
        <title><%=temp.getUsername()%>(Admin) Dashboard</title>
    </head>
    <body>
        <h1>Welcome <%=temp.getUsername()%> to your dashboard, </h1>
        Online Users:<br>----------------------<br>
        <%
            for(User user:UserControlListener.activeUsers){
        %>
            <%=user.getUsername()%> ONLINE<br>
        <%
            }
        %>
    </body>
</html>
