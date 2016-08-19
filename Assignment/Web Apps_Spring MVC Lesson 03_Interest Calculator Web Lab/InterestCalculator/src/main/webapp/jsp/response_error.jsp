<%-- 
    Document   : response_error
    Created on : Jul 9, 2016, 5:27:47 PM
    Author     : Kratos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Result</title>
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
            <div class="row">
                <div class="text-center col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3">
                    <h1>Interest Calculator</h1>
                    <hr/>
                    <!-- Error Message -->
                    <div class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span>
                        ${error}
                    </div>
                    
                    <!-- give the form again -->
                    <form class="form-inline" role="getInput" name="index" action="${pageContext.request.contextPath}/interestCalculator/calculate" method="POST">
                        <br>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon equalLengthPre">Interest Rate</div>
                                <input type="text" class="form-control" name="interestRate">
                                <div class="input-group-addon equalLengthPost">%</div>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon equalLengthPre">Principal</div>
                                <input type="text" class="form-control" name="principal">
                                <div class="input-group-addon equalLengthPost">.00</div>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon equalLengthPre">Years</div>
                                <input type="text" class="form-control" name="years">
                                <div class="input-group-addon equalLengthPost">.00</div>
                            </div>
                        </div>
                        <br>
                        <br>
                        <label class="c-input c-radio">
                            <input id="radio1" name="compoundPeriod" type="radio" value="quarterly"> 
                            <span class="c-indicator"></span>
                            Quarterly &nbsp;&nbsp;&nbsp;
                        </label>
                        <label class="c-input c-radio">
                            <input id="radio2" name="compoundPeriod" type="radio" value="monthly">
                            <span class="c-indicator"></span>
                            Monthly &nbsp;&nbsp;&nbsp;
                        </label>
                        <label class="c-input c-radio">
                            <input id="radio2" name="compoundPeriod" type="radio" value="daily">
                            <span class="c-indicator"></span>
                            Daily &nbsp;&nbsp;&nbsp;
                        </label>
                        <br>
                        <br>
                        <br>
                        <button type="submit" class="btn btn-primary">Calculate</button>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
