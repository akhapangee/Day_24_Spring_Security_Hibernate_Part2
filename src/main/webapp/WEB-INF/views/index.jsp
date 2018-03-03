<%-- 
    Document   : index
    Created on : Feb 26, 2018, 9:13:19 PM
    Author     : Akhilesh
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
        <h1><a href="${pageContext.request.contextPath}/login">Login to Secured Area</a></h1>
         <h1>Courses</h1>
        <ul>
            <c:forEach var="course" items="${courses}">
                       <li>${course.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
