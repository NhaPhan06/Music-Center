<%-- 
    Document   : CheckStatus
    Created on : Aug 24, 2022, 9:57:43 PM
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
        <h1>Check status of order</h1>
        <%
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <br/>   
        <form action="MainController" method="get">
            Search: <input type="text" name="searchOrder" value="<%= search%>">
            <input type="submit" name="action" value="SearchOrder">
        </form>
        <%
            int count = 1;
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>  
                    <th>Course ID</th>
                    <th>Quantity</th>
                    <th>Date Buy</th>
                    <th> Status</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${ListO}" var="o">
                <tr>
                    <td><%=count++%></td>
                    <td>${o.courseID}</td>
                    <td>${o.quantity}</td>
                    <td>${o.dateBuy}</td>
                    <td>${o.status}</td>                        
                </tr>
            </c:forEach>
        </tbody>
    </table> 
</body>
</html>
