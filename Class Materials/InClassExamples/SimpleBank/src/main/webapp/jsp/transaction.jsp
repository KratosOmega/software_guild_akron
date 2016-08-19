<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Transaction Details</title>
    </head>
    <body>
        <h1>Transaction Details</h1>
        <h3>Transaction Id: ${transaction.id}</h3>
        <h3>Account Number: ${transaction.accountId}</h3>
        <h3>Amount: ${transaction.amount}</h3>
        <h3>Note: ${transaction.note}</h3>
        <h3>Date: ${transaction.date}</h3>
        
        <a href="home">Home</a>
    </body>
</html>
