<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Contacts</title>
        <!-- add Bootstrap -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Company Contacts</h1>
            <!-- #1 Link to addContactForm -->
            <a href="displayContactListNoAjax">Contact List (No AJAX)</a><br />
            <hr />

            <form class="form-horizontal" role="form" action="addNewContactNoAjax" method="POST">
                <div class="form-group">
                    <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="add-first-name" name="firstName" placeholder="First Name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="add-last-name" name="lastName" placeholder="Last Name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-company" class="col-md-4 control-label">Company:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="add-company" name="company" placeholder="Company" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-email" class="col-md-4 control-label">Email:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="add-email" name="email" placeholder="Email address (hi@no.com)" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-phone" class="col-md-4 control-label">Phone:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="add-phone" name="phone" placeholder="Phone (216-555-1212)" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit" id="add-button" 
                                class="btn btn-default">Add New Contact</button>
                    </div>
                </div>
            </form>

        </div>

        <!-- Placing our JS at the end of the document so that the page loads faster-->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
