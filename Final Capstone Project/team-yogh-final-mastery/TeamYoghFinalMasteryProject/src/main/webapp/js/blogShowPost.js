$(document).ready(function (param) {
    loadPost();

});

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

function loadPost() {
    clearPosts();

    var page = getParameterByName('postId');

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/TeamYoghFinalMasteryProject/api/posts/" + page,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    };


    $.ajax(settings).done(function (post, status) {
        setValue(post);
    });
}

function setValue(post) {
    $("#showPostTitle").html(post.post.post_title);
    $("#showPostContent").html(post.post.post_content);
    $("#showAuthor").html(post.user.user_name);
    $("#showDate").html(post.post.post_publish_date);
    $.each(post.tags, function (index, item) {
        $("#post-tags").html(item.tag_name);
    });
}

function clearPosts() {
    $("#showPostTitle").empty();
    $("#showPostContent").empty();
    $("#showAuthor").empty();
    $("#showDate").empty();

    $("#post-tags").empty();
}
