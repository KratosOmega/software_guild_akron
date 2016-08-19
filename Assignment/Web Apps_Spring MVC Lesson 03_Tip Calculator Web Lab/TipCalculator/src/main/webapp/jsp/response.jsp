<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/additional.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <div class="text-center col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3">
                <div class="panel panel-primary">
                    <div class="panel-heading"><h1>Tip Calculator</h1></div>
                    <br>
                    <div class="panel-body">
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Result Summary</h4></div>
                            <div class="panel-body">
                                <table class="table table-hover">
                                    <tbody>
                                        <tr>
                                            <td class="tbDescription">Subtotal</td>
                                            <td class="tbValue">$ ${data.get("subTotal")}</td>
                                        </tr>
                                        <tr>
                                            <td class="tbDescription">Tip Rate</td>
                                            <td class="tbValue">${data.get("tipRate")} %</td>
                                        </tr>
                                        <tr>
                                            <td class="tbDescription">Tip</td>
                                            <td class="tbValue">$ ${data.get("tip")}</td>
                                        </tr>
                                        <tr>
                                            <td class="tbDescription">Total</td>
                                            <td class="tbValue">$ ${data.get("total")}</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <hr>
                                <a href="${pageContext.request.contextPath}/" class="btn btn-default">Done</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

