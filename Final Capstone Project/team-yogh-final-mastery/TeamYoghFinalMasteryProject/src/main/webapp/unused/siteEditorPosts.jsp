<%-- 
    Document   : siteEditorPosts
    Created on : Aug 3, 2016, 2:32:07 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Posts | Site Editor</title>

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
            <a href="${pageContext.request.contextPath}/jsp/siteEditorPosts.jsp" style="text-decoration:none"><div id="posts" class="side-link active"><center>Posts</div></a>
            <a href="${pageContext.request.contextPath}/jsp/siteEditorPages.jsp" style="text-decoration:none"><div id="pages" class="side-link"><center>Pages</div></a>
            <a href="${pageContext.request.contextPath}/jsp/siteEditorComments.jsp" style="text-decoration:none"><div id="comments" class="side-link"><center>Comments</div></a>
            <a href="${pageContext.request.contextPath}/jsp/siteEditorUsers.jsp" style="text-decoration:none"><div id="users" class="side-link"><center>Users</div></a>
        </div>

        <div id="posts-div" class="siteEditorDivs col-xs-12 col-sm-12 col-md-11 col-lg-11">
            <br><br>
            <div class="border-div col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
            <div class="content-div col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <br>
                <div id="new-post-button" class="new-button">NEW POST</div>
                <br><br><br>
                <div id="post-lister">
                    <center>
                        <br>
                        <!-- each post div gets put into here -->
                        <!-- or it gets put into a table -->
                        <div id="no-posts">NO POSTS YET...</div> <!-- no-posts div is given the class "hidden" when there are posts -->
                        <br>
                    </center>
                </div>
                <br>
            </div>
            <div class="border-div col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
        </div>

        <!-- add new post modal (taken care of in other javascript file? -->
        <div id="new-post-modal" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="new-post-modal-title">NEW POST</h3>
                    </div>
                    <div class="modal-body">
                        <center>
                            <form role="form">
                                <div>
                                    <input type="text" id="post-title" style="width:80%" placeholder="Post Title">
                                </div>
                                <br>
                                <div>
                                    <textarea id="post-body" placeholder="Post Body" style="width:80%;height:400px"></textarea>
                                </div>
                                <br>
                                <div>
                                    <input type="text" data-role="tagsinput" placeholder="tags">
                                    <span id="create-cancel-buttons">
                                    <button type="submit" id="create-new-post-button" class="btn" data-dismiss="modal">CREATE POST</button>
                                    <button type="button" class="btn modal-close-button" data-dismiss="modal">Cancel</button>
                                    </span>
                                </div>
                                <br><br>
                            </form>
                        </center>
                    </div>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/editPageVisualScript.js"></script>
    </body>
</html>
