<%-- 
    Document   : response_error
    Created on : Jul 10, 2016, 12:27:21 AM
    Author     : Kratos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
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
                    <div class="panel-body">
                        <!-- Error Message -->
                        <div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            ${error}
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Enter data to calculate</h4></div>
                            <div class="panel-body">
                                <form class="form-inline" role="getInput" name="index" action="${pageContext.request.contextPath}/tipCalculator/calculate" method="POST">
                                    <br>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon equalLengthPre">Amount</div>
                                            <input type="text" class="form-control" name="amount">
                                            <div class="input-group-addon equalLengthPost">.00</div>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon equalLengthPre">Tip rate</div>
                                            <input type="text" class="form-control" name="tipRate">
                                            <div class="input-group-addon equalLengthPost">%</div>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <br>
                                    <button type="submit" class="btn btn-primary">Calculate</button>
                                </form>
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