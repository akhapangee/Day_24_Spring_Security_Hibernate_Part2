<%-- 
    Document   : index
    Created on : Mar 3, 2018, 7:54:14 PM
    Author     : Akhilesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Secured Area</h1>
        <a href="${pageContext.request.contextPath}/login/logout">Logout</a>
    </body>
</html>
