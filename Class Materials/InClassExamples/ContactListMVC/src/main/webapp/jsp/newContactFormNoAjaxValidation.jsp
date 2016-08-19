<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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

            <sf:form class="form-horizontal" role="form" modelAttribute="contact" action="addNewContactNoAjaxValidation" method="POST">
                <div class="form-group">
                    <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-first-name" path="firstName" placeholder="First Name" />
                        <sf:errors path="firstName" cssClass="warning"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-last-name" path="lastName" placeholder="Last Name" />
                        <sf:errors path="lastName" cssClass="warning"></sf:errors>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-company" class="col-md-4 control-label">Company:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-company" path="company" placeholder="Company" />
                        <sf:errors path="company" cssClass="warning"></sf:errors>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-email" class="col-md-4 control-label">Email:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-email" path="email" placeholder="Email address (hi@no.com)" />
                        <sf:errors path="email" cssClass="warning"></sf:errors>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-phone" class="col-md-4 control-label">Phone:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-phone" path="phone" placeholder="Phone (216-555-1212)" />
                        <sf:errors path="phone" cssClass="warning"></sf:errors>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="add-button" 
                                    class="btn btn-default">Add New Contact</button>
                        </div>
                    </div>
            </sf:form>

        </div>

        <!-- Placing our JS at the end of the document so that the page loads faster-->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
