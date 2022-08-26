<%-- 
    Document   : OrderSuccess
    Created on : Aug 25, 2022, 2:57:06 PM
    Author     : PhongNha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:if test="${LOGIN_USER != null}">
            <h1>${LOGIN_USER.userID} Buy Success </h1>
        </c:if>
        <c:if test="${LOGIN_USER == null}">
            <h1> ${Order} Buy Success </h1>
        </c:if>
    </body>
</html>
