<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="../../assets/js/html5shiv.js"></script>
          <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
        <title>Simple Bank Home</title>
    </head>
    <body>
        <h1>Simple Bank Home</h1>
        <ol>
            <c:forEach var="holder" items="${accountHolders}"> 

                <s:url value="/accountHolder" 
                       var="accountHolder_url" >
                    <s:param name="accountHolderId" 
                             value="${holder.id}" />
                </s:url>

                <li>
                    <span class="spittleListText">
                        <a href="${accountHolder_url}">
                            <c:out value="${holder.name}" /></a>
                        - <c:out value="${holder.name}" />
                    </span></li>
                </c:forEach>
        </ol>

        <a href="accountHolder?new">Create new Account Holder</a>
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="javascript/jquery-1.10.2.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="javascript/bootstrap.js"></script> 
    </body>
</html>
