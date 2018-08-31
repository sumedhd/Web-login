

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WEB LOGIN</title>
    </head>
    <body>
        
         <h1>WEB LOGIN</h1>
        <a href="http://localhost:8080/WebLogin/home.jsp">LOGOUT</a>
        
    <% 
        String username= request.getParameter("username");
     out.println("Welcome "+username);
    %>
    
    </body>
</html>
