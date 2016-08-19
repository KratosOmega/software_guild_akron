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
                    <div class="panel-heading"><h1>Flooring Calculator</h1></div>
                    <div class="panel-body">
                        <div class="alert alert-warning" role="alert">
                            <h4>Labor Charging Rule</h4>
                            <hr>
                            20 ft<sup>2</sup> flooring per hour at a cost of $86.00/hour 
                            <br>
                            15-minute billing increment
                        </div>
                        <hr>
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Enter data to calculate</h4></div>
                            <div class="panel-body">
                                <form class="form-inline" role="getInput" name="index" action="${pageContext.request.contextPath}/flooringCalculator/calculate" method="POST">
                                    <br>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon equalLengthPre">Width</div>
                                            <input type="text" class="form-control" name="floorWidth">
                                            <div class="input-group-addon equalLengthPost">ft</div>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon equalLengthPre">Length</div>
                                            <input type="text" class="form-control" name="floorLength">
                                            <div class="input-group-addon equalLengthPost">ft</div>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon equalLengthPre">Flooring price</div>
                                            <input type="text" class="form-control" name="flooringPrice">
                                            <div class="input-group-addon equalLengthPost">$/ft<sup>2</sup></div>
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

