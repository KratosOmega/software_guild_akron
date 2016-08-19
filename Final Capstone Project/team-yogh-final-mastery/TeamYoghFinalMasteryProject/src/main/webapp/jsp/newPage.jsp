<%-- 
    Document   : newPage
    Created on : Aug 9, 2016, 11:29:36 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>New Page | Site Editor</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/alternateEditStyles.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/jQuery-Tags-Input-master/src/jquery.tagsinput.css" rel="stylesheet">
    </head>
    <body>
        <div id="top-navbar" class="fixed-top">
            <span id="topbar-brand" class="fade" title="home">YOGH|Site Editor</span>
            <span class="topbar-item fade"><a href="${pageContext.request.contextPath}/j_spring_security_logout">LOGOUT</a></span>
        </div>
        <div id="options-navbar" class="fixed-top">
            <div id="new-post" class="options-item">New Post</div>
            <div id="new-page" class="options-item active">New Page</div>
            <div id="users" class="options-item">Users</div>
            <div id="search" class="options-item">Search</div>
        </div>

            <br><br><br>
    <center>
        <div id="new-page-form" class="new-form">
            <br>
            <center>
                <input type="text" id="title-input" name="tab-name" placeholder="PAGE TAB NAME">
                <br><br>
                <!-- upload image here -->
                <!-- enter alt here -->
                <div id="post-body"><textarea name="new-post-text" id="new-post-text"></textarea></div>
                <br><br>
                <div id="preview-submit">
                    <!-- <button class="preview fade">preview</button> -->
                    <button type="submit" class="submit fade">create</button>
                </div>
                <br>
                </div>
            </center>



            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
            <script src="${pageContext.request.contextPath}/ckeditor/adapters/jquery.js"></script>
            <script src="${pageContext.request.contextPath}/jQuery-Tags-Input-master/src/jquery.tagsinput.js"></script>
            <script src="${pageContext.request.contextPath}/js/alternateEditScript.js"></script>
            </body>
            </html>