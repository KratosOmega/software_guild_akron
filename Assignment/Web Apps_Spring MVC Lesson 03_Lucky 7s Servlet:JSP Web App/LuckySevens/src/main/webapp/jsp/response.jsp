<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lucky Sevens Result</title>
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
            <div class="row toCenter">
                <div class="col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3">
                    <h1>Lucky Sevens</h1>
                    <hr/>
                    <form role="getInput" name="index" action="${pageContext.request.contextPath}/luckySevens/roll" method="POST">
                        <h3>Start to bet</h3>
                        <br>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">$</div>
                                <input type="text" class="form-control" name="initialBet" placeholder="Amount">
                                <div class="input-group-addon">.00</div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Roll Again</button>
                        <a href="${pageContext.request.contextPath}/" class="btn btn-default">Return</a>
                    </form>
                    <hr>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Description</th>
                                <th>Value</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Starting Bet</td>
                                <td>${data.get("Starting Bet")}</td>
                            </tr>
                             <tr>
                                <td>Total Roll</td>
                                <td>${data.get("Total Roll")}</td>
                            </tr>
                             <tr>
                                <td>Highest Amount</td>
                                <td>${data.get("Highest Amount")}</td>
                            </tr>
                             <tr>
                                <td>Highest Roll</td>
                                <td>${data.get("Highest Roll")}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

