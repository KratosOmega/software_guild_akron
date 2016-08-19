$(document).ready(function () {

    $("#add-post").click(function (event) {
        event.preventDefault();

        // Get a proper date formate in js in order to match MySQL date type
        var date;
        date = new Date();
        date = date.getUTCFullYear() + '-' +
                ('00' + (date.getUTCMonth() + 1)).slice(-2) + '-' +
                ('00' + date.getUTCDate()).slice(-2) + ' ' +
                ('00' + date.getUTCHours()).slice(-2) + ':' +
                ('00' + date.getUTCMinutes()).slice(-2) + ':' +
                ('00' + date.getUTCSeconds()).slice(-2);
        // ------------------

        var postObject = {
            post_title: $("#title-input").val(),
            post_content: $("#new-post-text").val(),
            post_publish_date: date, // This line need to be updated later when we implment the functionality to update the publish feature
            post_create_date: date,
            user_id: 1,
            category_id: 1,
            status_id: 1
        };

        var tagList = {
            tag_name: $("#post-tags").val()
        };

        $.ajax({
            type: 'POST',
            url: 'api/posts',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify({
                post: postObject,
                tags: tagList
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            cache: false
        }).success(function (data, status) {
            $("#title-input").val("");
            $("#new-post-text").val("");
            $("#post-tags").val("");

            $('#validationErrors').empty();

            //  }).error(function (data, status) {
            //      $('#validationErrors').empty();
            //      $.each(data.responseJSON.fieldErrors, function (index, validationError) {
            //          var errorDiv = $('#validationErrors');
            //          errorDiv.append(validationError.message).append($('<br>'));
            //      });
        });
    });
});



/*
 * 
 *                 tag_name: $("#post-tags").val()
 */