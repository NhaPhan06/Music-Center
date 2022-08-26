<%-- 
    Document   : UpdateCousre
    Created on : Aug 19, 2022, 8:05:58 PM
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
            User log = (User) session.getAttribute("LOGIN_USER");

            List<User> users = (List<User>) request.getAttribute("LIST_USER");

            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>

        <form action="MainController" method="POST">
            <input class="fa fa-user s_color" type="submit" name="action" value="logout" />
        </form>
        <a href="OrderManagementController"> Status Update </a>
        <h1> Welcome: <%= log.getUserID()%> </h1>
        <a href="CreateCourse.jsp"> Create<a/>
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
                    <th>Update Date</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                %>
                <c:forEach items="${ListC}" var="o">
                <form action="MainController">
                    <tr>
                        <td><%=count++%></td>
                        <td><input type="text" name="courseID" value="${o.courseID}" readonly/></td>
                        <td><img src="${o.image}" style="width: 100px"></td>
                        <td><input type="text" name="courseName" value="${o.courseName}"/></td>
                        <td><input type="text" name="description" value="${o.description}"/></td>
                        <td><input type="text" name="category" value="${o.category}"/></td>
                        <td>${o.createDate}</td>
                        <td><input type="date" name="endDate" value="${o.endDate}"/></td> 
                        <td><input type="number" name="quantity" value="${o.quantity}" min="${o.quantity}" max="50"/></td>
                        <td><input type="number" name="tuitionFee" value="${o.tuitionFee}" min="${o.tuitionFee}" max="100000000" step="10000"/></td>
                        <td>${o.update}</td>
                        <td><input type="submit" name="action" value="Update"/></td>
                    </tr> 
                </form>
            </c:forEach>
            <a href="CreateCourse.jsp"> Create<a/>
z
                </tbody>
        </table> 
        <%
            String error_msg = (String) request.getAttribute("ERROR");
            if (error_msg == null) {
                error_msg = "";
            }
        %>
        <%= error_msg%>

    </body>
</html>
