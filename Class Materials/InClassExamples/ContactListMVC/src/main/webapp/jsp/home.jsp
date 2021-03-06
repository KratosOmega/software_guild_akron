<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Contacts</title>
        <!-- add Bootstrap -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Company Contacts</h1>
            <hr />
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayContactListNoAjax">Contact List (No AJAX)</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <!-- Our list of contacts -->
                    <h2>My Contacts</h2>
                    <table id="contactTable" class="table table-hover table-striped">
                        <tr>
                            <th width="40%">Contact Name</th>
                            <th width="30%">Company</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <!-- This is where our contacts will be.  We will populate this with JS -->
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <!-- Add contact form -->
                    <h2>Add New Contact</h2>
                    <div id="validationErrors" class="warning bg-danger"></div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-first-name" 
                                   class="col-md-4 control-label">First Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-first-name" placeholder="First Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-last-name" 
                                   class="col-md-4 control-label">Last Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-last-name" placeholder="Last Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-company" 
                                   class="col-md-4 control-label">Company:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-company" placeholder="Company" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-email" 
                                   class="col-md-4 control-label">Email:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-email" placeholder="Email (hi@no.com)" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-phone" 
                                   class="col-md-4 control-label">Phone:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-phone" placeholder="Phone" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-default">
                                    Create Contact
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- Modal to display contact details -->
            <!-- aria- attributes for Accessible Rich Internet Applications standards
            their purpose is to make web applications more accessible to people with disabilities.
            -->
            <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
                 aria-labelledby="detailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="detailsModalLabel">Contact Details</h4>
                        </div>
                        <div class="modal-body">
                            <h3 id="contactId"></h3>
                            <table class="table table-bordered">
                                <tr>
                                    <th>First Name:</th>
                                    <td id="contact-firstName"></td>
                                </tr>
                                <tr>
                                    <th>Last Name:</th>
                                    <td id="contact-lastName"></td>
                                </tr>
                                <tr>
                                    <th>Company:</th>
                                    <td id="contact-company"></td>
                                </tr>
                                <tr>
                                    <th>Phone:</th>
                                    <td id="contact-phone"></td>
                                </tr>
                                <tr>
                                    <th>Email:</th>
                                    <td id="contact-email"></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                 aria-labelledby="editDetailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="editDetailsModalLabel">Edit Contact</h4>
                        </div>
                        <div class="modal-body">
                            <h2>Edit Contact</h2>
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-first-name" 
                                           class="col-md-4 control-label">First Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-first-name" placeholder="First Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-last-name" 
                                           class="col-md-4 control-label">Last Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-last-name" placeholder="Last Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-company" 
                                           class="col-md-4 control-label">Company:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-company" placeholder="Company" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-email" 
                                           class="col-md-4 control-label">Email:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-email" placeholder="Email (hi@no.com)" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-phone" 
                                           class="col-md-4 control-label">Phone:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-phone" placeholder="Phone" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit"
                                                id="edit-button"
                                                class="btn btn-default" data-dismiss="modal">
                                            Edit Contact
                                        </button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>

                                        <input type="hidden" id="edit-contact-id" />
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Placing our JS at the end of the document so that the page loads faster-->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/contactList.js"></script>
    </body>
</html>
