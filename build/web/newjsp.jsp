<%-- 
    Document   : newjsp
    Created on : Aug 25, 2022, 3:17:05 PM
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
       <form action="/RemoveCartController?pg=FIBiller&amp;cmd=delete">
    <input type="submit" value="delete" onclick="return confirm('Are you sure you want to delete?')" />
    <input type="hidden" name="ID" value="fasdf"/> 
</form>
    </body>
</html>
