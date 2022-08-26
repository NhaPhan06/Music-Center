<%-- 
    Document   : Home
    Created on : Aug 18, 2022, 11:05:29 PM
    Author     : PhongNha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.DAO.Course"%>
<%@page import="java.util.List"%>
<%@page import="sample.DAO.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <c:if test="${LOGIN_USER != null}">
            <h1> Welcome:  ${LOGIN_USER.userID}</h1>
            <form action="MainController" method="POST">
                <input class="fa fa-user s_color" type="submit" name="action" value="logout" />
            </form>
        </c:if>
        <c:if test="${LOGIN_USER == null}">
            <a href="Login.jsp" type="button">Login</a>
        </c:if>
            
            <br/>
            <a href="CheckStatus.jsp" type="button">Check</a>
            <br/>
            
            
        <h1>  Search course  </h1>
        <form action="MainController" method="get">
            Search: <input type="text" name="searchByText" value="<%= search%>">
            Category: <select name="searchByCate">
                <option></option>
                <option value="Piano">Piano</option>
                <option value="Guitar">Guitar</option>
                <option value="Sao">Sao truc</option>
            </select>
            <input type="submit" name="action" value="Search">
        </form>
        </br>
        </br>
        <table border="1">
            <thead>
                <tr>
                    <th>NO</th> 
                    <th>Course ID</th> 
                    <th>Image</th>
                    <th>Course Name</th>
                    <th>description</th>
                    <th>Category</th>
                    <th>Create Date</th>
                    <th>End Date</th>
                    <th>Quantity</th>
                    <th>Tuition Fee</th>
                    <th>Add to cart</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                %>
                <c:forEach items="${ListC}" var="o">
                <form action="MainController">
                    <input type="hidden" name="ID" value="${o.courseID}"/>
                    <tr>
                        <td><%=count++%></td>
                        <td>${o.courseID}</td>
                        <td><img src="${o.image}" style="width: 100px"></td>
                        <td>${o.courseName}</td>
                        <td>${o.description}</td>
                        <td>${o.category}</td>                        
                        <td>${o.createDate}</td>
                        <td>${o.endDate}</td> 
                        <td>${o.quantity}</td>
                        <td>${o.tuitionFee}</td>
                        <td><input type="submit" name="action" value="AddToCart"/></td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>
    </table> 
    <c:forEach begin="1" end="${endP}" var="i">
        <a href="ShowCourseController?index=${i}">${i}</a>
    </c:forEach>
    <a href="CartController"> Cart<a/>
        <%
            String error_msg = (String) request.getAttribute("ERROR");
            if (error_msg == null) {
                error_msg = "";
            }
        %>
        <%= error_msg%>

</body>
</html>
