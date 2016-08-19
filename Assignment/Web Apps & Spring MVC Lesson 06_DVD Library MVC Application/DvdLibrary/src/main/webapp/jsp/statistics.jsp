<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Spring MVC Application from Archetype</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/statistics">Statistics</a></li>
                </ul>    
            </div>

            <div id="statisticsResult" class="row">
                <table id="statisticsTable" class="table table-bordered"></table>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <button id="avgAge" class="btn btn-primary">Average Age</button>
                </div>
                <div class="col-md-3">
                    <button id="newest" class="btn btn-primary">Newest</button>
                </div>
                <div class="col-md-3">
                    <button id="oldest" class="btn btn-primary">Oldest</button>
                </div>
                <div class="col-md-3">
                    <button id="avgNote" class="btn btn-primary">Average Note</button>
                </div>
            </div>


            <!-- modal goes here -->
            <!-- Edit Modal -->
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editDetailsModalLabel" aria-hidden="true">

                <div class="modal-dialog">

                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="editDetailsModalLabel">Edit DVD</h4>
                        </div>

                        <div class="modal-body">
                            <h2>Edit DVD</h2>
                            <form class="form-horizontal" role="form" action="homeEdit" method="POST">
                                <div class="form-group">
                                    <label for="edit-dvd-title" class="col-md-4 control-label">Title:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-title" name="title" placeholder="Title" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-dvd-releaseDate" class="col-md-4 control-label">Release Date:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-releaseDate" name="releaseDate" placeholder="Release Date" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-dvd-mpaaRating" class="col-md-4 control-label">MPAA Rating</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-mpaaRating" name="mpaaRating" placeholder="MPAA Rating" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-dvd-director" class="col-md-4 control-label">Director:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-director" name="director" placeholder="Director" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-dvd-studio" class="col-md-4 control-label">Studio:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-studio" name="studio" placeholder="Studio" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-dvd-note" class="col-md-4 control-label">Note:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-note" name="note" placeholder="Note" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit" id="edit-button" class="btn btn-default">Edit DVD</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                        <input type="hidden" id="edit-dvd-id" name="id" />
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Delete Modal -->
            <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="delteDetailsModalLabel" aria-hidden="true">

                <div class="modal-dialog">

                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="deleteDetailsModalLabel">Delete DVD</h4>
                        </div>

                        <div class="modal-body">
                            <h2>Delete DVD</h2>
                            <form class="form-horizontal" role="form" action="homeDelete" method="POST">
                                <div class="form-group">
                                    <label for="delete-dvd-title" class="col-md-4 control-label">Title:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="delete-dvd-title" name="title" placeholder="Title" disabled/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="delete-dvd-releaseDate" class="col-md-4 control-label">Release Date:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="delete-dvd-releaseDate" name="releaseDate" placeholder="Release Date" disabled/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="delete-dvd-mpaaRating" class="col-md-4 control-label">MPAA Rating</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="delete-dvd-mpaaRating" name="mpaaRating" placeholder="MPAA Rating" disabled/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="delete-dvd-director" class="col-md-4 control-label">Director:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="delete-dvd-director" name="director" placeholder="Director" disabled/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="delete-dvd-studio" class="col-md-4 control-label">Studio:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="delete-dvd-studio" name="studio" placeholder="Studio" disabled/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="delete-dvd-note" class="col-md-4 control-label">Note:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="delete-dvd-note" name="note" placeholder="Note" disabled/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit" id="delete-button" class="btn btn-default">Delete DVD</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                        <input type="hidden" id="delete-dvd-id" name="id" />
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>

                </div>

            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/dvdLibraryActions.js"></script>
        <script src="${pageContext.request.contextPath}/js/statisticsActions.js"></script>
    </body>
</html>
