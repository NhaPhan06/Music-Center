<%-- 
    Document   : Cart
    Created on : Aug 22, 2022, 2:06:43 PM
    Author     : PhongNha
--%>
<%@page import="java.util.List"%>
<%@page import="sample.DAO.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>Cart</h1>
        <form action="MainController" method="get">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th> 
                        <th>ID</th> 
                        <th>Image</th>
                        <th>Course Name</th>
                        <th>Category</th>
                        <th>Quantity</th>
                        <th>Tuition Fee</th>
                        <th>Price</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                    %>

                    <c:forEach items="${cartItems}" var="ci">
                        <tr>
                            <td><%=count++%></td>
                            <td><input type="text" name="ID" value="${ci.course.courseID}" readonly/></td>
                            <td><img src="${ci.course.image}" style="width: 100px"></td>
                            <td>${ci.course.courseName}</td>
                            <td>${ci.course.category}</td>                        
                            <td><input name="${ci.course.courseID}" type="number" max="${ci.course.quantity}" min="1" value="${ci.quantity}" required/></td>
                            <td>$ ${ci.course.tuitionFee}</td>
                            <td>$ ${ci.price}</td>
                            <td><a href="RemoveCartController?ID=${ci.course.courseID}"/>Remove</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit" name="action" value="UpdateCart"/> 
        </form>

        <div class="row my-5">
            <div class="col-lg-8 col-sm-12"></div>
            <div class="col-lg-4 col-sm-12">
                <div class="order-box">
                    <h3>Order summary</h3>
                    <div class="d-flex gr-total">
                        <h5>Grand Total</h5>
                        <div class="ml-auto h5">$ ${cart.sumPrice} </div>
                    </div>
                    <hr> </div>
            </div>

            <form action="MainController" method="get">
                <c:if test="${sessionScope.log == null}">
                    <input type="hidden" name="login" value="null"/>
                    <input type="submit" name="action" value="Order"/>
                </c:if>
                <c:if test="${sessionScope.log != null}">
                    <input type="submit" name="action" value="Order"/>
                    <input type="hidden" name="login" value="notNull"/>
                </c:if>
            </form>


        </div>
    </body>
</html>
