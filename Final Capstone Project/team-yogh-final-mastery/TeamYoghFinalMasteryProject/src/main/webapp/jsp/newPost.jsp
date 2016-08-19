<%-- 
    Document   : newPost
    Created on : Aug 9, 2016, 9:57:44 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>New Post | Site Editor</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/alternateEditStyles.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/jQuery-Tags-Input-master/src/jquery.tagsinput.css" rel="stylesheet">
    </head>
    <body>
        <div id="top-navbar" class="fixed-top">
            <span id="topbar-brand" class="fade" title="home">YOGH|Site Editor</span>
            <span class="topbar-item fade"><a href="${pageContext.request.contextPath}/j_spring_security_logout">LOGOUT</a></span>
        </div>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div id="options-navbar" class="fixed-top">
            <div id="new-post" class="options-item active">New Post</div>
            <div id="new-page" class="options-item">New Page</div>
            <div id="users" class="options-item">Users</div>
            <div id="search" class="options-item">Search</div>
        </div>
        </sec:authorize>

        <br><br><br>
    <center>
        <div id="new-post-form" class="new-form">
            <br>
            <center>
                <input type="text" id="title-input" name="post-title" placeholder="POST TITLE">
                <br><br>
                <!-- upload image here -->
                <!-- enter alt here -->
                <!-- enter caption here? -->
                <select id="post-categories" name="post-categories">
                    <option value="Back-End">Back-End</option>
                    <option value="Front-End">Front-End</option>
                    <option value="JAVA">JAVA</option>
                    <option value="C#">C#</option>
                    <option value=".NET">.NET</option>
                    <option value="Misc.">Misc.</option>
                </select>
                <br><br>
                <div id="post-body"><textarea name="new-post-text" id="new-post-text"></textarea></div>
                <br><br>
                <input type="text" id="post-tags" name="post-tags" value="new,post">
                <br><br>
                <div id="preview-submit">
                    <!--<button class="preview fade">preview</button>-->
                    <button type="submit" id="add-post" class="submit fade">submit</button>
                </div>
                <br>
                </div>
        <br>
            </center>



            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
            <script src="${pageContext.request.contextPath}/ckeditor/adapters/jquery.js"></script>
            <script src="${pageContext.request.contextPath}/jQuery-Tags-Input-master/src/jquery.tagsinput.js"></script>
            <script src="${pageContext.request.contextPath}/js/alternateEditScript.js"></script>
            <script src="${pageContext.request.contextPath}/js/post.js"></script>

            </body>
            </html>