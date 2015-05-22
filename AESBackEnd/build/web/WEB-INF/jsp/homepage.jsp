<%-- 
    Document   : login
    Created on : May 19, 2015, 10:57:49 AM
    Author     : Ted Ian Osias
--%>


<%@page import="AES.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User temp = (User)session.getAttribute("user");
            
        %>
        <h1>Login! 
            <%=temp.getUsername()%><br>
            this is you homepage!
        </h1>
        
    </body>
</html>
