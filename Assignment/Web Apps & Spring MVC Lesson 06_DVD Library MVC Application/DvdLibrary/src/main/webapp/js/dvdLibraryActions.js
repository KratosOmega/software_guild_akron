/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    fillTable();

    // Search
    $("#search-button").click(function (event) {
        event.preventDefault();

        $.ajax({
            type: "POST",
            url: "search/dvds",
            dataType: "json",
            data: JSON.stringify({
                title: $('#search-title').val(),
                releaseDate: $('#search-releaseDate').val(),
                mpaaRating: $('#search-mpaaRating').val(),
                director: $('#search-director').val(),
                studio: $('#search-studio').val(),
                note: $('#search-note').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).success(function (data, status) {
            $('#search-title').val("");
            $('#search-releaseDate').val("");
            $('#search-mmpaRating').val("");
            $('#search-director').val("");
            $('#search-studio').val("");
            $('#search-note').val("");

            loadData(data, status);
        });
    });

    // Remove
});


function fillTable() {
    $.ajax({
        type: "GET",
        url: "getDvds"
    }).success(function (data, status) {
        loadData(data, status);
    });
}

function clearTable() {
    $("#contentTable").empty();
}

// pass in json data to load on the contentTable
function loadData(data, status) {

    clearTable();

    var contentTable = $("#contentTable");

    $.each(data, function (key, value) {
        contentTable.append($("<tr>")
                .append($("<td>").text(value.id))
                .append($("<td>").text(value.title))
                .append($("<td>").text(value.releaseDate))
                .append($("<td>").text(value.mpaaRating))
                .append($("<td>").text(value.director))
                .append($("<td>").text(value.studio))
                .append($("<td>").text(value.note))
                .append($("<td>")
                        .append($("<button>")
                                .attr({
                                    "class": "btn btn-primary",
                                    "id": "editDvdBtn-" + key,
//                                        "data-dvd": dvd,
                                    "data-toggle": "modal",
                                    "data-target": "#editModal"
                                })
                                .text("Edit"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append($("<button>")
                                .attr({
                                    "class": "btn btn-primary",
                                    "id": "deleteDvdBtn-" + key,
                                    "data-toggle": "modal",
                                    "data-target": "#deleteModal"
                                }).text("Delete")))
                );
        // assign the every single dvd object to every single edit button
//        $("#editDvdBtn-" + key).data("dvd", value);
//        $("#deleteDvdBtn-" + key).data("dvd", value);
        $("#editDvdBtn-" + key).data("dvd", value);
        $("#deleteDvdBtn-" + key).data("dvd", value);
    });
}

/*
function refreshDvdLibraryList() {
    // clear the previous list
    clearTable();

    // get dvd tbody
    var dvdTable = $("#contentTable");

    $.getJSON("getDvds", function (dvds) {
        $.each(dvds, function (key, dvd) {
            dvdTable.append($("<tr>")
                    .append($("<td>").text(dvd.id))
                    .append($("<td>").text(dvd.title))
                    .append($("<td>").text(dvd.releaseDate))
                    .append($("<td>").text(dvd.mpaaRating))
                    .append($("<td>").text(dvd.director))
                    .append($("<td>").text(dvd.studio))
                    .append($("<td>").text(dvd.note))
                    .append($("<td>")
                            .append($("<button>")
                                    .attr({
                                        "class": "btn btn-primary",
                                        "id": "editDvdBtn-" + key,
//                                        "data-dvd": dvd,
                                        "data-toggle": "modal",
                                        "data-target": "#editModal"
                                    })
                                    .text("Edit"))
                            .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append($("<button>")
                                    .attr({
                                        "class": "btn btn-primary",
                                        "id": "deleteDvdBtn-" + key,
                                        "data-toggle": "modal",
                                        "data-target": "#deleteModal"
                                    }).text("Delete")))
                    );
            // assign the every single dvd object to every single edit button
            $("#editDvdBtn-" + key).data("dvd", dvd);
            $("#deleteDvdBtn-" + key).data("dvd", dvd);
        });
    });
}
*/


// Modal
$("#editModal").on("show.bs.modal", function (event) {
    var element = $(event.relatedTarget);
    var dvd = element.data("dvd");

    var modal = $(this);
//     sampleContact is hard-coded currently
//     You could use this with an AJAX call later on
    modal.find("#edit-dvd-id").val(dvd.id);
    modal.find("#edit-dvd-title").val(dvd.title);
    modal.find("#edit-dvd-releaseDate").val(dvd.releaseDate);
    modal.find("#edit-dvd-mpaaRating").val(dvd.mpaaRating);
    modal.find("#edit-dvd-director").val(dvd.director);
    modal.find("#edit-dvd-studio").val(dvd.studio);
    modal.find("#edit-dvd-note").val(dvd.note);
});

$("#deleteModal").on("show.bs.modal", function (event) {
    var element = $(event.relatedTarget);
    var dvd = element.data("dvd");

    var modal = $(this);
//     sampleContact is hard-coded currently
//     You could use this with an AJAX call later on
    modal.find("#delete-dvd-id").val(dvd.id);
    modal.find("#delete-dvd-title").val(dvd.title);
    modal.find("#delete-dvd-releaseDate").val(dvd.releaseDate);
    modal.find("#delete-dvd-mpaaRating").val(dvd.mpaaRating);
    modal.find("#delete-dvd-director").val(dvd.director);
    modal.find("#delete-dvd-studio").val(dvd.studio);
    modal.find("#delete-dvd-note").val(dvd.note);
});