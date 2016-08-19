<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Result</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <div class="text-center col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3">
                <h1>Interest Calculator</h1>
                <hr/>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Year #</th>
                            <th>Beginning Balance</th>
                            <th>Interest</th>
                            <th>Ending Balance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="report" items="${data}">
                            <tr>
                                <td><c:out value="${data.indexOf(report) + 1}"/></td>
                                <c:forEach var="reportData" items="${report}">
                                    <td><c:out value="${reportData}"/></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br>
                <br>
                <a href="${pageContext.request.contextPath}/" class="btn btn-default">Done</a>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

