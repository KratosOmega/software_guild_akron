<%-- 
    Document   : siteEditor
    Created on : Aug 2, 2016, 9:48:38 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Home | Site Editor</title>
        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/editPageStyles.css" rel="stylesheet">
    </head>
    <body>
        <div id="top_navbar">
            <nav id="topbar" class="navbar navbar-fixed-top">
                <a class="navbar-brand fade" href="${pageContext.request.contextPath}/jsp/siteEditor.jsp">Site Editor</a>
                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item"><a class="nav-link" href="#">LOGIN</a></li>
                </ul>
            </nav>
        </div>]

        <div id="side_navbar" class="hidden-xs hidden-sm">
            <div id="navbar_spacing"></div>
            <a href="${pageContext.request.contextPath}/jsp/siteEditorPosts.jsp" style="text-decoration:none"><div id="posts" class="side-link"><center>Posts</div></a>
            <a href="${pageContext.request.contextPath}/jsp/siteEditorPages.jsp" style="text-decoration:none"><div id="pages" class="side-link"><center>Pages</div></a>
            <a href="${pageContext.request.contextPath}/jsp/siteEditorComments.jsp" style="text-decoration:none"><div id="comments" class="side-link"><center>Comments</div></a>
            <a href="${pageContext.request.contextPath}/jsp/siteEditorUsers.jsp" style="text-decoration:none"><div id="users" class="side-link"><center>Users</div></a>
        </div>
        
        
        <div id="posts-div" class="siteEditorDivs col-xs-12 col-sm-12 col-md-11 col-lg-11">
            <br><br>
            <div class="border-div col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
            <div class="content-div col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <br>
                <br><br><br>
                <br>
            </div>
            <div class="border-div col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
        </div>
        

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/editPageVisualScript.js"></script>
    </body>
</html>
