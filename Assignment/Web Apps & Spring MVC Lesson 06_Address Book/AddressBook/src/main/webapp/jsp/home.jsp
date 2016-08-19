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
                    <!-- Our list of contacts -->
                    <h2>Address Book</h2>
                    <table id="contactTable" class="table table-hover table-striped">
                        <tr>
                            <th width="20%">Name</th>
                            <th width="50%">Address</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <!-- This is where our contacts will be.  We will populate this with JS -->
                        <tbody id="addressTable"></tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <!-- Add contact form -->
                    <h2>Add & Search</h2>
                    <div id="addValidationErrors" class="warning bg-danger"></div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="addSearch-address-firstName" class="col-md-4 control-label">First Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addSearch-address-firstName" placeholder="First Name" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="addSearch-address-lastName" class="col-md-4 control-label">Last Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addSearch-address-lastName" placeholder="Last Name" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="addSearch-address-houseNumber" class="col-md-4 control-label">House Number:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addSearch-address-houseNumber" placeholder="House Number" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="addSearch-address-street" class="col-md-4 control-label">Street:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addSearch-address-street" placeholder="Street" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="addSearch-address-city" class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addSearch-address-city" placeholder="City" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="addSearch-address-state" class="col-md-4 control-label">State:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addSearch-address-state" placeholder="State" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="addSearch-address-zioCode" class="col-md-4 control-label">Zip Code:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addSearch-address-zipCode" placeholder="Zip Code" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="addSearch-address-country" class="col-md-4 control-label">Country</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addSearch-address-country" placeholder="Country" />
                            </div>
                        </div>

                        <div class="form-inline">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">Add Address</button>
                                <button type="submit" id="search-button" class="btn btn-success">Search Address</button>
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
                            <h4 class="modal-title" id="detailsModalLabel">Address Details</h4>
                        </div>

                        <div class="modal-body">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Address</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td id="details-address-id"></td>
                                        <td id="details-address-name"></td>
                                        <td id="details-address-address"></td>
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
                            <h4 class="modal-title" id="editDetailsModalLabel">Edit Address</h4>
                        </div>

                        <div class="modal-body">
                            <h2>Edit Address</h2>
                            <br>
                            <div id="editValidationErrors" class="warning bg-danger"></div>
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-address-firstName" class="col-md-4 control-label">First Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address-firstName" name="firstName" placeholder="First Name" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-address-lastName" class="col-md-4 control-label">Last Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address-lastName" name="lastName" placeholder="Last Name" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-address-houseNumber" class="col-md-4 control-label">House Number:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address-houseNumber" name="houseNumber" placeholder="House Number" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-address-street" class="col-md-4 control-label">Street:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address-street" name="street" placeholder="Street" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-address-city" class="col-md-4 control-label">City:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address-city" name="city" placeholder="City" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-address-state" class="col-md-4 control-label">State:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address-state" name="state" placeholder="State" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-address-zipCode" class="col-md-4 control-label">Zip Code:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address-zipCode" name="zipCode" placeholder="Zip Code" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-address-country" class="col-md-4 control-label">Country:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address-country" name="country" placeholder="Country" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit" id="edit-button" class="btn btn-default">Edit Address</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                        <input type="hidden" id="edit-address-id" name="id" />
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