<%-- 
    Document   : search
    Created on : Aug 9, 2016, 11:30:21 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Search | Site Editor</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/alternateEditStyles.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/jQuery-Tags-Input-master/src/jquery.tagsinput.css" rel="stylesheet">
    </head>
    <body>
        <div id="top-navbar" class="fixed-top">
            <span id="topbar-brand" class="fade" title="home">YOGH|Site Editor</span>
            <span class="topbar-item fade">LOGOUT</span>
        </div>
        <div id="options-navbar" class="fixed-top">
            <div id="new-post" class="options-item">New Post</div>
            <div id="new-page" class="options-item">New Page</div>
            <div id="users" class="options-item">Users</div>
            <div id="search" class="options-item active">Search</div>
        </div>


        <div id="admin-search">
            <div id="posts-lister">
                <div class="lister-title">POSTS</div>
                <div id="post-list" class="lister">
                    <div class="post">
                        <div class="post-title" style="text-shadow:2px 2px red">Post Title</div>
                        <div class="post-author">Author420</div>
                        <div class="post-options hidden-sm hidden-xs">
                            <button class="approve fade" title="approve">+</button>
                            <button class="edit fade" title="edit">*</button>
                            <button class="delete fade" title="delete">X</button>
                        </div>
                    </div>
                </div>
            </div>
            <div id="search-lister">
                <div class="lister-title">SEARCH</div>
                <br>
                <center>
                    <div id="search-div" class="search-form" style="height:20%"><br><br>
                        <input type="text" id="data-search" class="search-option" name="data-search" placeholder="SEARCH KEYWORD"><br><br><br><br><br>
                        <button id="search-button" title="search">SEARCH</button>
                    </div>
                </center>
                <br>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
        <script src="${pageContext.request.contextPath}/ckeditor/adapters/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/jQuery-Tags-Input-master/src/jquery.tagsinput.js"></script>
        <script src="${pageContext.request.contextPath}/js/alternateEditScript.js"></script>
    </body>
</html>