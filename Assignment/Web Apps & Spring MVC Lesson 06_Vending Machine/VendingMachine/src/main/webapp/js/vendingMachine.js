/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    refreshVendingMachine();
    $("#purchaseSuccessed").hide();
    $("#purchaseFailed").hide();
    $("#changeTable").hide();

});

function clearTable() {
    $("#vendingMachineTable").empty();
}

function refreshVendingMachine() {
    $.ajax({
        type: "GET",
        url: "getCurrentInventory"
    }).success(function (data, status) {
        loadData(data, status);
    });
}

function loadData(data, status) {

    clearTable();

    var contentTable = $("#vendingMachineTable");

    $.each(data, function (key, value) {
        contentTable.append($("<tr>")
                .attr({
                    "id": "item-" + key
                })
                .append($("<td>").text(value.itemName))
                .append($("<td>").text(value.itemPrice))
                .append($("<td>").text(value.itemQty))
                .append($("<td>")
                        .append($("<button>")
                                .attr({
                                    "id": "btn-" + key,
                                    "class": "btn btn-primary button-status",
                                    "disabled": true,
                                    "onclick": "selected(" + key + ")"
                                })
                                .text("Select"))));
    });
}

// --------------------------------------------------------------- make sure the btn are interacted correctly
var isSelected = false;
var selection = -1;
var moneyPool = 0;
var tempMoney = 0;

function insert(money) {
    moneyPool += money;
    $("#currentMoney").text("$" + moneyPool / 100);

    if (!isSelected) {
        tempMoney += money;
        $('.button-status').prop("disabled", false);
    } else {
        $.ajax({
            type: 'POST',
            url: 'insert/' + selection + "/" + money,
            dataType: "text"
        }).success(function (data, status) {
            var diff = Number(data);
            if (diff >= 0) {
                $.ajax({
                    type: 'POST',
                    url: 'change/' + diff,
                    dataType: 'json'
                }).success(function (data, status) {
                    // show successfully purchase
                    $("#purchaseSuccessed").hide();
                    $("#purchaseFailed").hide();
                    $("#purchaseSuccessed").append($("<p>").text("You had successfully make this purchase!"));
                    $("#purchaseSuccessed").append($("<p>").text("Selection: " + selection));
                    $("#purchaseSuccessed").show();
                    // show changes
                    $("#changes").empty();
                    $("#changes").append($("<tr>")
                            .append($("<td>").text(data.quarters))
                            .append($("<td>").text(data.dimes))
                            .append($("<td>").text(data.nickels))
                            .append($("<td>").text(data.cents)));
                    $("#changeTable").show();
                    // update the inventory
                    $.ajax({
                        type: 'PUT',
                        url: 'updateInv/' + selection,
                        dataType: 'json'
                    }).success(function (data, status) {
                        // reload the vm table
                        loadData(data, status);
                    });
                });
                isSelected = false;
                moneyPool = 0;
                $('.button-status').prop("disabled", true);
            } else {
                $("#purchaseSuccessed").hide();
                $("#purchaseFailed").hide();
                $("#notification div").empty();
                $("#purchaseFailed").append($("<p>").text("Not enough money! You still need $ " + (-diff / 100)));
                $("#purchaseFailed").append($("<p>").text("Selection: " + selection));
                $("#purchaseFailed").show();
            }
        });
    }
}

function selected(key) {
    if (!isSelected) {
        $('.button-status').prop("disabled", true);
        $('#btn-' + key).prop("disabled", false);
        selection = key;
        isSelected = true;

        $("#currentMoney").text("$" + moneyPool / 100);

        $.ajax({
            type: 'POST',
            url: 'insert/' + selection + "/" + tempMoney,
            dataType: "text"
        }).success(function (data, status) {
            var diff = Number(data);
            if (diff >= 0) {
                $.ajax({
                    type: 'POST',
                    url: 'change/' + diff,
                    dataType: 'json'
                }).success(function (data, status) {
                    // show successfully purchase
                    $("#purchaseSuccessed").hide();
                    $("#purchaseFailed").hide();
                    $("#purchaseSuccessed").append($("<p>").text("You had successfully make this purchase!"));
                    $("#purchaseSuccessed").show();
                    // show changes
                    $("#changes").empty();
                    xsxs
                    $("#changes").append($("<tr>")
                            .append($("<td>").text(data.quarters))
                            .append($("<td>").text(data.dimes))
                            .append($("<td>").text(data.nickels))
                            .append($("<td>").text(data.cents)));
                    $("#changeTable").show();
                    // update the inventory
                    // update the inventory
                    $.ajax({
                        type: 'PUT',
                        url: 'updateInv/' + selection,
                        dataType: 'json'
                    }).success(function (data, status) {
                        // reload the vm table
                        loadData(data, status);
                    });
                });
                isSelected = false;
                moneyPool = 0;
                $('.button-status').prop("disabled", true);
                refreshVendingMachine();
            } else {
                $("#purchaseSuccessed").hide();
                $("#purchaseFailed").hide();
                $("#notification div").empty();
                $("#purchaseFailed").append($("<p>").text("Not enough money! You still need $" + (diff / 100)));
                $("#purchaseFailed").append($("<p>").text("Selection: " + selection));
                $("#purchaseFailed").show();
            }
        });
        tempMoney = 0;
    }
}




/*
 // add address
 $('#add-button').click(function (event) {
 event.preventDefault();
 // need to submit this via AJAX
 $.ajax({
 type: 'POST',
 url: 'address',
 // make the JSON contact
 data: JSON.stringify({
 firstName: $('#addSearch-address-firstName').val(),
 lastName: $('#addSearch-address-lastName').val(),
 houseNumber: $('#addSearch-address-houseNumber').val(),
 street: $('#addSearch-address-street').val(),
 city: $('#addSearch-address-city').val(),
 state: $('#addSearch-address-state').val(),
 zipCode: $('#addSearch-address-zipCode').val(),
 country: $('#addSearch-address-country').val()
 }),
 contentType: 'application/json; charset=utf-8',
 headers: {
 'Accept': 'application/json',
 'Content-Type': 'application/json'
 },
 dataType: 'json'
 }).success(function (data, status) {
 // clear the form and reload the summary table
 $('#addSearch-address-firstName').val('');
 $('#addSearch-address-lastName').val('');
 $('#addSearch-address-houseNumber').val('');
 $('#addSearch-address-street').val('');
 $('#addSearch-address-city').val('');
 $('#addSearch-address-state').val('');
 $('#addSearch-address-zipCode').val('');
 $('#addSearch-address-country').val('');
 
 // reload the summary table
 $('#addValidationErrors').empty();
 refreshVendingMachine();
 }).error(function (data, status) {
 $('#addValidationErrors').empty();
 $.each(data.responseJSON.fieldErrors, function (index, validationError) {
 var errorDiv = $('#addValidationErrors');
 errorDiv.append(validationError.message).append($('<br>'));
 });
 });
 });
 
 // edit address
 $('#edit-button').click(function (event) {
 event.preventDefault();
 // update our contact via AJAX
 $.ajax({
 type: 'PUT',
 url: 'address/' + $('#edit-address-id').val(),
 data: JSON.stringify({
 id: $('#edit-address-id').val(),
 firstName: $('#edit-address-firstName').val(),
 lastName: $('#edit-address-lastName').val(),
 houseNumber: $('#edit-address-houseNumber').val(),
 street: $('#edit-address-street').val(),
 city: $('#edit-address-city').val(),
 state: $('#edit-address-state').val(),
 zipCode: $('#edit-address-zipCode').val(),
 country: $('#edit-address-country').val()
 }),
 headers: {
 'Accept': 'application/json',
 'Content-Type': 'application/json'
 },
 'dataType': 'json'
 }).success(function () {
 $('#editValidationErrors').empty();
 $('#editModal').modal('hide');
 refreshVendingMachine();
 }).error(function (data, status) {
 $('#editValidationErrors').empty();
 $.each(data.responseJSON.fieldErrors, function (index, validationError) {
 var errorDiv = $('#editValidationErrors');
 errorDiv.append(validationError.message).append($('<br>'));
 });
 });
 });
 
 // search address
 $("#search-button").click(function (event) {
 event.preventDefault();
 $.ajax({
 type: 'POST',
 url: 'address/search',
 dataType: 'json',
 data: JSON.stringify({
 firstName: $('#addSearch-address-firstName').val(),
 lastName: $('#addSearch-address-lastName').val(),
 houseNumber: $('#addSearch-address-houseNumber').val(),
 street: $('#addSearch-address-street').val(),
 city: $('#addSearch-address-city').val(),
 state: $('#addSearch-address-state').val(),
 zipCode: $('#addSearch-address-zipCode').val(),
 country: $('#addSearch-address-country').val()
 }),
 headers: {
 'Accept': 'application/json',
 'Content-Type': 'application/json'
 }
 }).success(function (data, status) {
 // clear the form and reload the summary table
 $('#addSearch-address-firstName').val('');
 $('#addSearch-address-lastName').val('');
 $('#addSearch-address-houseNumber').val('');
 $('#addSearch-address-street').val('');
 $('#addSearch-address-city').val('');
 $('#addSearch-address-state').val('');
 $('#addSearch-address-zipCode').val('');
 $('#addSearch-address-country').val('');
 
 loadData(data, status);
 });
 });
 
 */