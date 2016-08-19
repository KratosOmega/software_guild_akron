<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Transfer Details</title>
    </head>
    <body>
        <h1>Transfer Details</h1>
        <h3>Transfer ID: ${transfer.id}</h3>
        <h3>To Account: ${transfer.toAccount}</h3>
        <h3>From Account: ${transfer.fromAccount}</h3>
        <h3>Amount: ${transfer.amount}</h3>
        <h3>Date: ${transfer.date}</h3>
        
        <a href="home">Home</a>
    </body>
</html>
