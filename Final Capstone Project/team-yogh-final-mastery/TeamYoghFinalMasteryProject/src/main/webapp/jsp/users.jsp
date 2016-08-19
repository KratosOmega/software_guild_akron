<%-- 
    Document   : users
    Created on : Aug 9, 2016, 11:30:09 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Users | Site Editor</title>

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
            <div id="new-page" class="options-item">New Page</div>
            <div id="users" class="options-item active">Users</div>
            <div id="search" class="options-item">Search</div>
        </div>

        <br><br><br>

        <div id="user-body">
        <div id="user-list">
            <div class="user">
                <div class="username">USERNAME</div>
                <div class="password">PASSWORD</div>
                <div class="user-role">ADMIN</div>
                <div class="user-options">
                    <button class="user-button edit-user fade">EDIT</button>
                    <button class="user-button remove-user fade">REMOVE </button>
                </div>
            </div>
        </div>
    <center>
        <div id="add-edit-user">
            <form id="add-edit-user-form">
                <h3>ENTER USER INFORMATION:</h3>
                <input type="text" id="username-input" name="username-input" placeholder="USERNAME"><br>
                <input type="text" id="password-input" name="password-input" placeholder="PASSWORD"><br>
                <select id="user-roles" name="user-roles">
                    <option value="User">USER</option>
                    <option value="Admin">ADMIN</option>
                </select><br><br>
                <button id="submit-user" type="submit">SUBMIT</button>
            </form>
        </div>
    </center>
        </div>

    <br>

    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
    <script src="${pageContext.request.contextPath}/ckeditor/adapters/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/jQuery-Tags-Input-master/src/jquery.tagsinput.js"></script>
    <script src="${pageContext.request.contextPath}/js/alternateEditScript.js"></script>
</body>
</html>
