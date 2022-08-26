<%-- 
    Document   : CreateCourse
    Created on : Aug 20, 2022, 8:16:12 PM
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
        <h1 class="title">Create Course</h1>
        <form class="contact-form row" action="MainController" method="GET">
            <div class="form-field col-lg-12">
                <p class="label">ID Course</p>
                <input id="name" name="ID"class="input-text js-input" type="text" required>
            </div>
            <div class="form-field col-lg-12">
                <p class="label">Name</p>
                <input id="name" name="Name"class="input-text js-input" type="text" required>
            </div>
            <div class="form-field col-lg-12">
                <p class="label">Image</p>
                <input  id="name"  name="Image"class="input-text js-input" type="text" required>
            </div>
            <div class="form-field col-lg-12">
                <p class="label">Description</p>
                <input  id="name"  name="Description"class="input-text js-input" type="text" required>
            </div>
            <div class="form-field col-lg-12">
                <p class="label">TuitionFee</p>
                <input  id="name" name="TuitionFee" class="input-text js-input" type="number" min="100000" max="10000000" step="10000" value="100000" required>
            </div>
            <div class="form-field col-lg-12">
                <p class="label">Start Date (Default is Today)</p>
            </div>
            <div class="form-field col-lg-12">
                <p class="label">EndDate</p>
                <input  id="name" name="EndDate" class="input-text js-input" type="date" min="2022-08-01" max="2023-01-01" required>
            </div>
            <div class="form-group">
                <p class="label">Category</p>
                <select name="Category" class="form-select" aria-label="Default select example">
                    <option></option>
                    <option value="Piano">Piano</option>
                    <option value="Guitar">Guitar</option>
                    <option value="Sao">Sao truc</option>
                </select>
            </div>
            <div class="form-field col-lg-12">
                <p class="label">Quantity</p>
                <input  id="name" name="Quantity" class="input-text js-input" type="number" max="30" min="5" value="5" required>
            </div>
            <div class="form-field col-lg-12">
                <input class="submit-btn" type="submit" name="action" value="CreateCourse">
            </div>
        </form>
    </body>
</html>
