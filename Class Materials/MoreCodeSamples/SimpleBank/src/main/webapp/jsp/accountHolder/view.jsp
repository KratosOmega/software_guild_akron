<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Account Holder - ${accountHolder.name}</title>
    </head>
    <body>
        <h1>Accounts for ${accountHolder.name}</h1>

        <ol>
            <c:forEach var="account" items="${accounts}"> 

                <s:url value="/account" 
                       var="account_url" >
                    <s:param name="accountId" 
                             value="${account.id}" />
                </s:url>

                <li>
                    <span>
                        <a href="${account_url}">
                            Account # <c:out value="${account.id}" /></a>
                        - Balance: <c:out value="${account.balance}" />
                    </span></li>
                </c:forEach>
        </ol>
        
        <a href="home">Home</a>

    </body>
</html>
