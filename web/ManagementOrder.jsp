<%-- 
    Document   : ManagementOrder
    Created on : Aug 24, 2022, 10:42:03 PM
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
        <h1>Hello World!</h1>
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
                    <th>Order ID</th>
                    <th>Course ID</th>
                    <th>Quantity</th>
                    <th>Date Buy</th>
                    <th>Status</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ListO}" var="o">
                <form action="MainController">
                    <tr>
                        <td><%=count++%></td>
                        <td><input type="text" name="orderID" value="${o.orderID}" readonly/></td>
                        <td><input type="text" name="courseID" value="${o.courseID}" readonly/></td>
                        <td>${o.quantity}</td>
                        <td>${o.dateBuy}</td>
                        <td><select name="status">
                                <option></option>
                                <option value="Payment completed">Payment completed</option>
                                <option value="Verification">Verification</option>
                                <option value="Successful">Successful</option>
                            </select>${o.status}</td>   
                            <td><input type="submit" name="action" value="UpdateOrder"></td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>
    </table> 
</body>
</html>
