$(document).ready(function () {
    $("#edit-post").click(function (event) {
        event.preventDefault();
        function getParameterByName(name, url) {
            if (!url)
                url = window.location.href;
            name = name.replace(/[\[\]]/g, "\\$&");
            var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
                    results = regex.exec(url);
            if (!results)
                return null;
            if (!results[2])
                return '';
            return decodeURIComponent(results[2].replace(/\+/g, " "));
        }

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
        var page = getParameterByName('postId');


        var postObject = {
            post_title: $("#title-input").val(),
            post_content: $("#new-post-text").val(),
//            post_publish_date: date, // This line need to be updated later when we implment the functionality to update the publish feature
//            post_create_date: date,
            user_id: 1,
            category_id: 1,
            status_id: 1,
            post_id: parseInt(page)
        };
        var tagList = {
            tag_name: $("#post-tags").val()
        };
//        var settings = {
//            "async": true,
//            "crossDomain": true,
//            "url": "http://localhost:8080/TeamYoghFinalMasteryProject/api/posts/" + page,
//            "method": "PUT",
//            "headers": {
//                'Accept': 'application/json',
//                'Content-Type': 'application/json',
//                "cache-control": "no-cache"
//            }
//        };
        $.ajax({
            type: 'PUT',
            url: 'api/posts/' + page,
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
        });

//        $.ajax(settings).done(function (data, status) {
//            $("#title-input").val("");
//            $("#new-post-text").val("");
//            $("#post-tags").val("");
////            $('#validationErrors').empty();

    });

});
;





//  }).error(function (data, status) {
//      $('#validationErrors').empty();
//      $.each(data.responseJSON.fieldErrors, function (index, validationError) {
//          var errorDiv = $('#validationErrors');
//          errorDiv.append(validationError.message).append($('<br>'));
//      })