<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                </ul>    
            </div>

            <div class="row">
                <div class="col-md-9">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Country</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody id="addressTable"></tbody>
                    </table>
                </div>


                <div class="col-md-3">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-firstName" class="control-label">First Name:</label>
                            <input type="text" class="form-control" id="search-firstName" placeholder="First Name"></input>
                        </div>
                        <div class="form-group">
                            <label for="search-lastName" class="control-label">Last Name:</label>
                            <input type="text" class="form-control" id="search-lastName" placeholder="Last Name"></input>
                        </div>
                        <div class="form-group">
                            <label for="search-houseNumber" class="control-label">House Number:</label>
                            <input type="text" class="form-control" id="search-houseNumber" placeholder="House Number"></input>
                        </div>
                        <div class="form-group">
                            <label for="search-street" class="control-label">Street:</label>
                            <input type="text" class="form-control" id="search-street" placeholder="Street"></input>
                        </div>

                        <div class="form-group">
                            <label for="search-city" class="control-label">City:</label>
                            <input type="text" class="form-control" id="search-city" placeholder="City"></input>
                        </div>
                        <div class="form-group">
                            <label for="search-zipCode" class="control-label">Zip Code:</label>
                            <input type="text" class="form-control" id="search-zipCode" placeholder="Zip Code"></input>
                        </div>
                        <div class="form-group">
                            <label for="search-state" class="control-label">Country:</label>
                            <select id="search-country"></select>
                        </div>

                        <div class="form-group">
                            <label for="search-state" class="control-label">State:</label>
                            <select id="search-state"></select>
                        </div>

                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="search-button" class="btn btn-primary">Search Address</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/home.js"></script>
    </body>
</html>