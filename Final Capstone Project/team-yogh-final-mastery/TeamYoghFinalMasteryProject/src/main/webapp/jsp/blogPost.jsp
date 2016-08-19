<%-- 
    Document   : blogPost
    Created on : Aug 16, 2016, 1:38:17 PM
    Author     : Owner
--%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Post | bl0g$ite</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/blogSiteStyles.css" rel="stylesheet">
    </head>
    <body>
        <div id="image-and-blur">
            <div id="not-blurred" class="img-src"></div>
            <div id="blurred" class="img-src"></div>
        </div>

        <div class="blog-name-header fade"><a href="${pageContext.request.contextPath}/">bl0g$ite</a></div>

        <div class="divider"><a href="archive">ARCHIVE</a></div>

        <div id="post-body">
            <!-- EXAMPLE POSTS -->
            <div id="blog-post">
                <div class="blog-post-title" id="showPostTitle"></div>
                <div class="blog-post-author" id="showAuthor"></div>
                <div class="blog-post-date" id="showDate"></div>
                <div class="blog-post-content" id="showPostContent">
                </div>
                <div class="blog-post-tags" id="post-tags"></div>
            </div>
            <div id="other-pages">
                <center>
                    <div id="other-pages-title">OTHER LINKS</div><br>
                    <div id="other-pages-links">
                        <div class="other-pages-link">Other Page</div>
                        <div class="other-pages-link">Another Page</div>
                        <div class="other-pages-link">One More Page</div>
                    </div>
                    <br>
                </center>
            </div>
            <br>
            <div id="bottom-div"></div>
        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/blogSiteVisualScript.js"></script>
        <script src="${pageContext.request.contextPath}/js/blogShowPost.js"></script>
    </body>
</html>
