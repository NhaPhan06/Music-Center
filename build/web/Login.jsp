<%-- 
    Document   : Login
    Created on : Aug 18, 2022, 2:07:22 PM
    Author     : PhongNha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="MainController" method="Post">
            User ID: <input type="text" name="userID" required="" placeholder="userID"/></br>
            Password: <input type="password" name="password" required="" placeholder="password"/></br>
            <input type="submit" name="action" value="login"/>
            <input type="reset" value="Reset"/>
        </form>
        <%
            String error = (String) request.getAttribute("ERROR");
            if (error == null) {
                error = "";
            }
        %>
        <%=error%>
        <br/>
        <a href="createAcc.jsp" >Create New User </a>

        <br/>

        <a href="ShowCourseController">Shopping</a>
    </body>
</html>
