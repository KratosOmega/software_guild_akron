<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Account ${account.id}</title>
    </head>
    <body>
        <h1>Account Details</h1>
        <h3>Account Number: ${account.id}</h3>
        <h3>Account Holder: ${accountHolder.name}</h3>
        <h3>Transactions (Deposits/Withdrawals)</h3>
        <ol>
            <c:forEach var="transaction" items="${transactions}"> 

                <s:url value="/transaction" 
                       var="transaction_url" >
                    <s:param name="transactionId" 
                             value="${transaction.id}" />
                </s:url>

                <li>
                    <span>
                        <a href="${transaction_url}">
                            Amount <c:out value="${transaction.amount}" /></a>
                        - Date: <c:out value="${transaction.date}" />
                        - Note:  <c:out value="${transaction.note}" />
                    </span></li>
                </c:forEach>
        </ol>
        
        <h3>Incoming Transfers</h3>
        <ol>
            <c:forEach var="transferIn" items="${transfersIn}"> 

                <s:url value="/transfer" 
                       var="transfer_url" >
                    <s:param name="transferId" 
                             value="${transferIn.id}" />
                </s:url>

                <li>
                    <span>
                        <a href="${transfer_url}">
                            Amount <c:out value="${transferIn.amount}" /></a>
                        - Date: <c:out value="${transferIn.date}" />
                        <s:url value="/account"
                               var="account_url" >
                            <s:param name="accountId"
                                     value="${transferIn.fromAccount}" />
                        </s:url>
                        - From:  <a href="${account_url}">Account <c:out value="${transferIn.fromAccount}" /></a>
                    </span></li>
                </c:forEach>
        </ol>
        
        <h3>Outgoing Transfers</h3>
        <ol>
            <c:forEach var="transferOut" items="${transfersOut}"> 

                <s:url value="/transfer" 
                       var="transfer_url" >
                    <s:param name="transferId" 
                             value="${transferOut.id}" />
                </s:url>

                <li>
                    <span>
                        <a href="${transfer_url}">
                            Amount <c:out value="${transferOut.amount}" /></a>
                        - Date: <c:out value="${transferOut.date}" />
                        <s:url value="/account"
                               var="account_url" >
                            <s:param name="accountId"
                                     value="${transferOut.toAccount}" />
                        </s:url>
                        - To:  <a href="${account_url}">Account <c:out value="${transferOut.toAccount}" /></a>
                    </span></li>
                </c:forEach>
        </ol>


        <a href="home">Home</a>
    </body>
</html>
