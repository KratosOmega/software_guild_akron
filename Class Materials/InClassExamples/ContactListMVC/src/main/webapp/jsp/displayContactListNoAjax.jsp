<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
            <a href="displayNewContactFormNoAjax">Add a Contact</a><br />
            <a href="displayNewContactFormNoAjaxValidation">Add a Contact (Validation)</a><br />

            <hr />
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation" >
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>

                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayContactListNoAjax">Contact List (No AJAX)</a>
                    </li>
                </ul>
            </div>
            <!-- #2 show our contacts stored in the model -->
            <c:if test="${fn:length(contactList) lt 1}">
                <form action="loadContacts" method="POST">
                    <button type="submit" class="btn btn-default">Load Test Contacts</button>
                </form>
            </c:if>
            <c:forEach var="person" items="${contactList}">
      
                <!-- #3 Build custom edit and delete URLs for each contact -->
                <s:url value="deleteContactNoAjax" var="deleteContact_url">
                    <s:param name="contactId" value="${person.contactId}" />
                </s:url>
                <s:url value="displayEditContactFormNoAjax" var="editContact_url">
                    <s:param name="contactId" value="${person.contactId}" />
                </s:url>

                <!-- #4 - A pointless demonstration of the if tag -->
                <c:if test="${person.lastName} == 'LeRoy'">
                    CEO<br />
                </c:if>
                Name: ${person.firstName} ${person.lastName} | <a href="${deleteContact_url}">Delete</a>  | <a href="${editContact_url}">Edit</a> <br/>
                Phone: ${person.phone} <br />
                Email: ${person.email}
                <hr/>
            </c:forEach>
        </div>

        <!-- Placing our JS at the end of the document so that the page loads faster-->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
