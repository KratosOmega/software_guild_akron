<%-- 
    Document   : response
    Created on : May 6, 2014, 10:25:47 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response</title>
    </head>
    <body>
        <h1>Response</h1>
        <a href="RSVPServlet">Home</a><br/>
        Your answer was: ${param.myAnswer}<br/>
        ${message}<br/>
    </body>
</html>
