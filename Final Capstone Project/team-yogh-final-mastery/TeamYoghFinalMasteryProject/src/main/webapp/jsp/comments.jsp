<%-- 
    Document   : comments
    Created on : Aug 9, 2016, 11:29:23 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Comments | Site Editor</title>

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
            <div id="search" class="options-item">Search</div>
        </div>

        <br><br><br>
        <center>
        <div id="comments-list" class="new-form">
            <br>
            <h3>COMMENTS</h3>
            <h4 id="comments-post-title">POST TITLE</h4>
            <br>
            <div id="comments-lister" class="lister">
                <div class="comment">
                    <div class="commenter-name">internetPoonSlaya</div>
                    <div class="commenter-email">troll@hotmail.com</div>
                    <div class="comment-text">Lorem Ipsum is simply dummy text of the printing
                        and typesetting industry. Lorem Ipsum has been the industry's standard 
                        dummy text ever since the 1500s, when an unknown printer took a galley 
                        of type and scrambled it to make a type specimen book. It has survived not 
                        only five centuries, but also the leap into electronic typesetting, 
                        remaining essentially unchanged. It was popularised in the 1960s with 
                        the release of Letraset sheets containing Lorem Ipsum passages, and more 
                        recently with desktop publishing software like Aldus PageMaker including
                        versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing
                        and typesetting industry. Lorem Ipsum has been the industry's standard 
                        dummy text ever since the 1500s, when an unknown printer took a galley 
                        of type and scrambled it to make a type specimen book. It has survived not 
                        only five centuries, but also the leap into electronic typesetting, 
                        remaining essentially unchanged. It was popularised in the 1960s with 
                        the release of Letraset sheets containing Lorem Ipsum passages, and more 
                        recently with desktop publishing software like Aldus PageMaker including
                        versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing
                        and typesetting industry. Lorem Ipsum has been the industry's standard 
                        dummy text ever since the 1500s, when an unknown printer took a galley 
                        of type and scrambled it to make a type specimen book. It has survived not 
                        only five centuries, but also the leap into electronic typesetting, 
                        remaining essentially unchanged. It was popularised in the 1960s with 
                        the release of Letraset sheets containing Lorem Ipsum passages, and more 
                        recently with desktop publishing software like Aldus PageMaker including
                        versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing
                        and typesetting industry. Lorem Ipsum has been the industry's standard 
                        dummy text ever since the 1500s, when an unknown printer took a galley 
                        of type and scrambled it to make a type specimen book. It has survived not 
                        only five centuries, but also the leap into electronic typesetting, 
                        remaining essentially unchanged. It was popularised in the 1960s with 
                        the release of Letraset sheets containing Lorem Ipsum passages, and more 
                        recently with desktop publishing software like Aldus PageMaker including
                        versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing
                        and typesetting industry. Lorem Ipsum has been the industry's standard 
                        dummy text ever since the 1500s, when an unknown printer took a galley 
                        of type and scrambled it to make a type specimen book. It has survived not 
                        only five centuries, but also the leap into electronic typesetting, 
                        remaining essentially unchanged. It was popularised in the 1960s with 
                        the release of Letraset sheets containing Lorem Ipsum passages, and more 
                        recently with desktop publishing software like Aldus PageMaker including
                        versions of Lorem Ipsum.</div>
                    <div class="comment-delete" title="delete comment">X</div>
                </div>
                <div class="comment">
                    
                </div>
                <div class="comment">
                    
                </div>
                <div class="comment">
                    
                </div>
                <div class="comment">
                    
                </div>
                <div class="comment">
                    
                </div>
            </div>
            <br>
            <div id="user-comment">
                <form id="user-comment-form">
                    <textarea id="user-comment-content"></textarea>
                    <br>
                    <button type="submit" id="submit-user-comment-button">post ></button>
                </form>
            </div>
            <br>
        </div>
            <br><br>
        </center>

    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
    <script src="${pageContext.request.contextPath}/ckeditor/adapters/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/jQuery-Tags-Input-master/src/jquery.tagsinput.js"></script>
    <script src="${pageContext.request.contextPath}/js/alternateEditScript.js"></script>
</body>
</html>