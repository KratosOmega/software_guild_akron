<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Site Lab - Home</title>
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
            <div id="header" class="row">
                <div class="text-center col-sm-12 col-md-12 col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1>Software Craftsmanship Guild Java Cohort</h1>
                            <h1>JSP Site Lab</h1>
                        </div>
                    </div>
                </div>
            </div>
            <div id="navBar" class="row">
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <ul class="nav nav-pills bg-info center-block">
                        <li role="siteNavigator" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li role="siteNavigator"><a href="${pageContext.request.contextPath}/luckySevens/index">Lukcy Sevens</a></li>
                        <li role="siteNavigator"><a href="${pageContext.request.contextPath}/factorizor/index">Factorizor</a></li>
                        <li role="siteNavigator"><a href="${pageContext.request.contextPath}/interestCalculator/index">Interest Calculator</a></li>
                        <li role="siteNavigator"><a href="${pageContext.request.contextPath}/flooringCalculator/index">Flooring Calculator</a></li>
                        <li role="siteNavigator"><a href="${pageContext.request.contextPath}/tipCalculator/index">Tip Calculator</a></li>
                        <li role="siteNavigator"><a href="${pageContext.request.contextPath}/unitConverter/index">Unit Converter</a></li>
                    </ul>
                </div>
            </div>
            <br>
            <!-- Page Content HERE *************************************************************************************** -->
            <div id="pageContent" class="row">
                <div class="text-center col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
                    <form class="form-inline" role="getProgram" name="index" action="${pageContext.request.contextPath}/chooseProgram/choose" method="POST">
                        <!-- Get Data here -->
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <br>
                                <div class="form-group">
                                    <div class="input-group">
                                        <select id="programSelection" name="program" class="form-control group-main" onchange="updateHomeImage()">
                                            <option value="#">Choose A Program</option>
                                            <option value="luckySevens">Lucky Sevens</option>
                                            <option value="factorizor">Factorizor</option>
                                            <option value="interest">Interest Calculator</option>
                                            <option value="flooring">Flooring Calculator</option>
                                            <option value="tip">Tip Calculator</option>
                                            <option value="unit">Unit Converter</option>
                                        </select>
                                    </div>
                                </div>
                                <br>
                                <br>
                            </div>
                            <div class="panel-body">
                                <br>
                                <br>
                                <!--<div class="col-sm-8 col-sm-offset-1 col-md-8 col-md-offset-1 col-lg-8 col-lg-offset-1">-->
                                <div id="programIntroduction"></div>
                                <hr>
                                <!--</div>-->
                                <br>
                                <div class="form-group">
                                    <button class="btn btn-primary" type="submit">Choose</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- Page Content HERE *************************************************************************************** -->

            <div id="footer" class="row">
                <div class="text-center col-sm-12 col-md-12 col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h5>Created By: Xin Li on July 2016</h5>
                            <h5>Powered By Java and Bootstrap</h5>
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
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/updateHomeImage.js"></script>
    </body>
</html>

