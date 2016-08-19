<%-- 
    Document   : siteEditorLandingPage
    Created on : Aug 9, 2016, 9:54:27 AM
    Author     : Owner
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home | Site Editor</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/alternateEditStyles.css" rel="stylesheet">
    </head>
    <body>

        <!--sec:authorize access="hasRole('ROLE_VISITOR')">
        <div id="log-in-access-landing-page">
            <div class="login-form">
                <form method="post" class="signin" action="j_spring_security_check">
                <center>
                    <br><br>
                    <h1>YOGH|Site Editor</h1>
                    <br><br><br>
                    <input type="text" id="username-input" class="login-input" placeholder="USERNAME">
                    <br><br>
                    <input type="password" id="password-input" class="login-input" placeholder="PASSWORD">
                    <br><br><br>
                    <button type="submit" id="login-button" class="login fade">LOGIN</button>
                    <br><br><br>
                </center>
                </form>
            </div>
        </div>
        </sec:authorize-->

        <!--sec:authorize access="hasRole('ROLE_USER')">
        <div id="user-access-landing-page"">
            <div id="top-navbar" class="fixed-top">
                <span id="topbar-brand" class="fade" href="${pageContext.request.contextPath}/editor" title="home">YOGH|Site Editor</span>
                <span class="topbar-item fade"><a href="${pageContext.request.contextPath}/j_spring_security_logout">LOGOUT</a></span>
            </div>

            <div id="user-post-lister">
                <div class="user-new-post fade">NEW POST</div>
                <div id="user-post-list">
                    <div class="user-post">
                        <div class="post">
                            <div class="post-date">08/05/2016</div>
                            <div class="post-title">Post Title</div>
                            <div class="post-options hidden-sm hidden-xs">
                                <button class="edit fade" title="edit">*</button>
                                <button class="comments fade" title="comments">!</button>
                                <button class="delete fade" title="delete">X</button>
                            </div>
                        </div>

                        <div class="post">
                            <div class="post-date">08/05/2016</div>
                            <div class="post-title">Post Title</div>
                            <div class="post-options hidden-sm hidden-xs">
                                <button class="edit fade" title="edit">*</button>
                                <button class="comments fade" title="comments">!</button>
                                <button class="delete fade" title="delete">X</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </sec:authorize-->

        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div id="admin-access-landing-page">
            <div id="top-navbar" class="fixed-top">
                <span id="topbar-brand" class="fade" href="${pageContext.request.contextPath}/editor" title="home">YOGH|Site Editor</span>
                <span class="topbar-item fade"><a href="${pageContext.request.contextPath}/j_spring_security_logout">LOGOUT</a></span>
            </div>
            <div id="options-navbar" class="fixed-top">
                <div id="new-post" class="options-item">New Post</div>
                <div id="new-page" class="options-item">New Page</div>
                <div id="users" class="options-item">Users</div>
                <div id="search" class="options-item">Search</div>
            </div>

            <div id="admin-home">
                <div id="posts-lister">
                    <div class="lister-title">POSTS</div>
                    <div id="post-list" class="lister">
                        <!-- test divs for where posts will appear -->
                        <!-- sample div for post -->
                        <div class="post">
                            <div class="post-date">08/05/2016</div>
                            <div class="post-title" style="text-shadow:2px 2px red">Post Title</div>
                            <!-- title character limit should be around 30/35 -->
                            <!-- if approved, title is Green; if, unapproved, title is Orange? -->
                            <div class="post-author">Author420</div>
                            <div class="post-options hidden-sm hidden-xs">
                                <button class="approve fade" title="approve">+</button>
                                <button class="edit fade" title="edit">*</button>
                                <button class="comments fade" title="comments">!</button>
                                <button class="delete fade" title="delete">X</button>
                            </div>
                        </div>
                        <div class="post">
                            <div class="post-date">08/06/2016</div>
                            <div class="post-title" style="text-shadow:2px 2px #70db70">Post Number Two</div>
                            <!-- title character limit should be around 30/35 -->
                            <!-- if approved, title is Green; if, unapproved, title is Orange? -->
                            <div class="post-author">SanicTheEdgehog</div>
                            <div class="post-options hidden-sm hidden-xs">
                                <button class="approve fade off" title="approve">+</button>
                                <button class="edit fade" title="edit">*</button>
                                <button class="comments fade" title="comments">!</button>
                                <button class="delete fade" title="delete">X</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="pages-lister">
                    <div class="lister-title">PAGES</div>
                    <div id="page-list" class="lister">
                        <div class="page">
                            <div class="page-title">ABOUT</div>
                            <div class="page-options hidden-sm hidden-xs">
                                <button class="publish-page fade" title="publish page">+</button>
                                <button class="edit-page fade" title="edit page">*</button>
                                <button class="delete-page fade" title="delete page">X</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </sec:authorize>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/showPostsAndPages.js"></script>
        <script src="${pageContext.request.contextPath}/js/alternateEditScript.js"></script>
    </body>
</html>