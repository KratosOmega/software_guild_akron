<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                </ul>    
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h2>Dvd Library</h2>
                    <table id="contactTable" class="table table-hover table-striped">
                        <tr>
                            <th width="20%">Dvd</th>
                            <th width="50%">Release Date</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="dvdTable"></tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Add & Search</h2>
                    <div id="addValidationErrors" class="warning bg-danger"></div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="dvd-title" class="col-md-4 control-label">DVD Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="dvd-title" placeholder="DVD Title" />
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="dvd-releaseDate" class="col-md-4 control-label">Release Date:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="dvd-releaseDate" placeholder="Release Date" />
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="dvd-mmpaRating" class="col-md-4 control-label">MMPA Rating:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="dvd-mmpaRating" placeholder="MMPA Rating" />
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="dvd-director" class="col-md-4 control-label">Director</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="dvd-director" placeholder="Director" />
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="dvd-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="dvd-studio" placeholder="Studio" />
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="dvd-note" class="col-md-4 control-label">Note:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="dvd-note" placeholder="Note" />
                            </div>
                        </div>

                        <div class="form-inline">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">Add DVD</button>
                                <button type="submit" id="search-button" class="btn btn-success">Search DVD</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <!-- modal goes here -->

            <!-- Detail Modal -->
            <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="detailsModalLabel">DVD Details</h4>
                        </div>

                        <div class="modal-body">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>DVD Title</th>
                                        <th>Release Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td id="details-dvd-id"></td>
                                        <td id="details-dvd-title"></td>
                                        <td id="details-dvd-releaseDate"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>

                    </div>
                </div>
            </div>

            <!-- Edit Modal -->
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
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
                            <br>
                            <div id="editValidationErrors" class="warning bg-danger"></div>
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-dvd-title" class="col-md-4 control-label">DVD Title;</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-title" name="title" placeholder="Title" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-dvd-releaseDate" class="col-md-4 control-label">Release Date:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-releaseDate" name="releaseDate" placeholder="ReleaseDate" />
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="edit-dvd-mmpaRating" class="col-md-4 control-label">MMPA Rating:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-dvd-mmpaRating" name="mmpaRating" placeholder="MMPA Rating" />
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



        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/home.js"></script>
    </body>
</html>