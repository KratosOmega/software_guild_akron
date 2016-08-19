<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Spring MVC Application from Archetype</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                </ul>    
            </div>
            <div class="row" style="text-align: center;">
                <div class="col-md-12">  
                    <div><h1>You had inserted:</h1><h1 id="currentMoney"></h1></div>
                    
                    <div id="notification">
                        <div id="purchaseSuccessed" class="alert alert-success" role="alert"></div>
                        <div id="purchaseFailed" class="alert alert-danger" role="alert"></div>
                    </div>

                    <table class="table table-bordered">
                        <tbody>
                            <tr>
                                <td><button id="d-5" class="btn btn-success" type="button" onclick="insert(500)">5 Dollars</button></td>
                                <td><button id="d-1" class="btn btn-success" type="button" onclick="insert(100)">1 Dollars</button></td>
                                <td><button id="quarter" class="btn btn-success" type="button" onclick="insert(25)">1 Quarter</button></td>
                                <td><button id="nickel" class="btn btn-success" type="button" onclick="insert(10)">1 Nickel</button></td>
                                <td><button id="dime" class="btn btn-success" type="button" onclick="insert(5)">1 Dime</button></td>
                                <td><button id="penny" class="btn btn-success" type="button" onclick="insert(1)">1 Penny</button></td>
                            </tr>
                        </tbody>
                    </table>
                    <hr>
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <td width="50%">Name</td>
                                <td width="20%">Price</td>
                                <td width="20%"># in Stock</td>
                                <td width="10%">Select</td>
                            </tr>
                        </thead>
                        <tbody id="vendingMachineTable"></tbody>
                    </table>
                    <hr>
                    <table id="changeTable" class="table table-bordered">
                        <thead>
                            <tr>
                                <th width="25%">Quarter</th>
                                <th width="25%">Dime</th>
                                <th width="25%">Nickel</th>
                                <th width="25%">Penny</th>
                            </tr>
                        </thead>
                        <tbody id="changes"></tbody>
                    </table>
                </div>
            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/vendingMachine.js"></script>
    </body>
</html>

