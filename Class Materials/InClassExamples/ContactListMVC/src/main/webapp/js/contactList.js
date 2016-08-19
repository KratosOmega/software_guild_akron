/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// When the document is ready, populate our summary table
$(document).ready(function () {
    loadContacts();

    // add the onclick handling for our add button
    $('#add-button').click(function (event) {
        event.preventDefault();
        // need to submit this via AJAX
        $.ajax({
            type: 'POST',
            url: 'contact',
            // make the JSON contact
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                email: $('#add-email').val(),
                phone: $('#add-phone').val()
            }),
            contentType: 'application/json; charset=utf-8',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            // clear the form and reload the summary table
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-company').val('');
            $('#add-phone').val('');
            $('#add-email').val('');

            // reload the summary table
            $('#validationErrors').empty();
            loadContacts();
        }).error(function (data, status) {
            $('#validationErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $('#edit-button').click(function (event) {
        event.preventDefault();
        // update our contact via AJAX
        $.ajax({
            type: 'PUT',
            url: 'contact/' + $('#edit-contact-id').val(),
            data: JSON.stringify({
                contactId: $('#edit-contact-id').val(),
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                company: $('#edit-company').val(),
                phone: $('#edit-phone').val(),
                email: $('#edit-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadContacts();
        });
    });

    $("#search-button").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/contacts',
            dataType: 'json',
            data: JSON.stringify({
                firstName: $('#search-first-name').val(),
                lastName: $('#search-last-name').val(),
                company: $('#search-company').val(),
                email: $('#search-email').val(),
                phone: $('#search-phone').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).success(function (data, status) {
            $('#search-first-name').val('');
            $('#search-last-name').val('');
            $('#search-company').val('');
            $('#search-email').val('');
            $('#search-phone').val('');

            fillContactTable(data, status);
        });
    });
});

// Load contacts into our summary table
function loadContacts() {
    //  Get our JSON object from the endpoint
    $.ajax({
        url: 'contacts'
    }).success(function (data, status) {
        fillContactTable(data, status);
    });
}

// used with Search button and loadContact function
function fillContactTable(contactList, status) {
    // clear the previous list
    clearContactTable();

    // store our tbody in a variable 
    var summaryTable = $('#contentRows');

    $.each(contactList, function (index, person) {
        summaryTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-contact-id': person.contactId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text((index) + ' - ' + person.firstName + ' ' + person.lastName)))
                .append($('<td>').text(person.company))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-contact-id': person.contactId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteContact(' + person.contactId + ')'
                                })
                                .text('Delete'))));
    });
}

// Clear all the rows from our summary table
function clearContactTable() {
    $('#contentRows').empty();
}

// Run in response to the show.bs.modal event
// It gets the contact data and renders it to the dialog
$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
    var modal = $(this);
    // Get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (sampleContact) {
        modal.find('#contact-id').text(sampleContact.contactId);
        modal.find('#contact-firstName').text(sampleContact.firstName);
        modal.find('#contact-lastName').text(sampleContact.lastName);
        modal.find('#contact-company').text(sampleContact.company);
        modal.find('#contact-phone').text(sampleContact.phone);
        modal.find('#contact-email').text(sampleContact.email);
    });
});

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
    var modal = $(this);

    // get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (sampleEditContact) {
        modal.find('#edit-contact-id').val(sampleEditContact.contactId);
        modal.find('#edit-first-name').val(sampleEditContact.firstName);
        modal.find('#edit-last-name').val(sampleEditContact.lastName);
        modal.find('#edit-company').val(sampleEditContact.company);
        modal.find('#edit-phone').val(sampleEditContact.phone);
        modal.find('#edit-email').val(sampleEditContact.email);
    });
});

function deleteContact(id) {
    var answer = confirm('Do you really want to delete this contact?');

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'contact/' + id
        }).success(function () {
            // reload summary
            loadContacts();
        });
    }
}        