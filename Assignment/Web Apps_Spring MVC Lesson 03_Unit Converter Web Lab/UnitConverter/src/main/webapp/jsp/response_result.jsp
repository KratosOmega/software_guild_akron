<%-- 
    Document   : response
    Created on : Jul 10, 2016, 8:42:46 AM
    Author     : Kratos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Result</title>
        <!-- Bootstrap core CSS -->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

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
                    <div class="panel-heading"><h1>Unit Converter</h1></div>
                    <div class="panel-body">
                        
                        <!-- Result Message -->
                        <div class="alert alert-success" role="alert">
                            <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
                            <span class="sr-only">Result</span>
                            ${data} ${unit}
                        </div>
                        
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Enter data to calculate</h4></div>
                            <div class="panel-body">

                                <!-- Get Data here -->
                                <form class="form-inline" role="getType" name="index" action="${pageContext.request.contextPath}/unitConverter/convert" method="POST">
                                    <br>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <select id="type" name="type" class="form-control group-main" onchange="updateSelection()">
                                                <option value="#">Conversion Type</option>
                                                <option value="temperature">Temperature</option>
                                                <option value="currency">Currency</option>
                                                <option value="volume">Volume</option>
                                                <option value="mass">Mass</option>
                                            </select>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group group-main form-inline">
                                        <div class="input-group">
                                            <select id="convertFrom" name="convertFrom" class="form-control " disabled onchange="updateInputField()">
                                                <option value="#">Convert From</option>
                                            </select>
                                        </div>
                                        <span class="glyphicon glyphicon-arrow-right"></span>
                                        <div class="input-group">
                                            <select id="convertTo" name="convertTo" class="form-control" disabled onchange="updateInputField()">
                                                <option value="#">Convert To</option>
                                            </select>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div id="inputSection" class="center-block input-group form-inline">
                                        <input id="inputSection_text" type="text" class="form-control" name="input" disabled>
                                        <div id="inputSection_button" class="input-group-btn">
                                            <button id="button" class="btn btn-primary" type="submit" disabled>Convert</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!-- Customized JS -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/updateSelection.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/updateInputField.js"></script>
    </body>
</html>
