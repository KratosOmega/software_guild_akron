/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $("#avgAge").click(function () {
        clearDiv();

        $.ajax({
            type: "GET",
            url: "avgAge",
            dataType: "text"
        }).success(function (data, status) {
            $("#statisticsTable").append($("<tr>").append($("<td>").text(data)));
        });
    });

    $("#newest").click(function () {
        clearDiv();

        $.ajax({
            type: "GET",
            url: "newest",
            dataType: "json"
        }).success(function (data, status) {
            loadStatisticsTable(data, status);
        });
    });

    $("#oldest").click(function () {
        clearDiv();

        $.ajax({
            type: "GET",
            url: "oldest",
            dataType: "json"
        }).success(function (data, status) {
            loadStatisticsTable(data, status);
        });
    });

    $("#avgNote").click(function () {
        clearDiv();

        $.ajax({
            type: "GET",
            url: "avgNote",
            dataType: "text"
        }).success(function (data, status) {
            $("#statisticsTable").append($("<tr>").append($("<td>").text(data)));
        });
    });
});

function clearDiv() {
    $("#statisticsTable").empty();
}

// pass in json data to load on the contentTable
function loadStatisticsTable(data, status) {
    clearDiv();

    var result = $("#statisticsTable");

    result.append($("<tr>")
            .append($("<td>").text(data.id))
            .append($("<td>").text(data.title))
            .append($("<td>").text(data.releaseDate))
            .append($("<td>").text(data.mpaaRating))
            .append($("<td>").text(data.director))
            .append($("<td>").text(data.studio))
            .append($("<td>").text(data.note))
            .append($("<td>")
                    .append($("<button>")
                            .attr({
                                "class": "btn btn-primary",
                                "id": "editDvdBtn",
//                                        "data-dvd": dvd,
                                "data-toggle": "modal",
                                "data-target": "#editModal"
                            })
                            .text("Edit"))
                    .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                    .append($("<button>")
                            .attr({
                                "class": "btn btn-primary",
                                "id": "deleteDvdBtn",
                                "data-toggle": "modal",
                                "data-target": "#deleteModal"
                            }).text("Delete")))
            );
    // assign the every single dvd object to every single edit button
//        $("#editDvdBtn-" + key).data("dvd", value);
//        $("#deleteDvdBtn-" + key).data("dvd", value);
    $("#editDvdBtn").data("dvd", data);
    $("#deleteDvdBtn").data("dvd", data);
}


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