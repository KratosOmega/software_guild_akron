$(document).ready(function () {

    loadPosts();

});

function loadPosts() {
    // clear previous list
    clearPosts();
//    store post list in a variable
//    var postList = $("#post-list");
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/TeamYoghFinalMasteryProject/api/posts",
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    };
    $.ajax(settings).done(function (data, status) {
        fillPostList(data, status);
    });

//    $.ajax(settings).done(function (response) {
//        console.log(response);
//    });


    // get JSON object from endpoint
//    $.ajax({
//        url: "http://localhost:8080/TeamYoghFinalMasteryProject/api/posts"
//    }).success(function (data, status) {
//        fillPostList(data, status);
//    });
}

function fillPostList(posts, status) {
    // clear previous list
    clearPosts();
    // store post list in a variable
    var postList = $("#post-list");

    // loop through JSON object
    $.each(posts, function (index, post) {
        postList.append($('<div>').attr({'class': 'post'})
                //.append($('<div class="post_create_date">').text(post.post_publish_date))
                .append($('<div>').attr({'class': 'post-title'}).text(post.post_title)
                .click(function () {
                                    document.location.href = 'editPost?postId=' + post.post_id;
                                }))
                //.append($('<div class="post-author">').text(post.bu.user_name))
                .append($('<div>').attr({'class': 'post-options hidden-sm hidden-xs'})
                        .append($('<button>').attr({'class': 'approve fade', 'title': 'approve'}).text("+"))
                        .append($('<button>').attr({'class': 'edit fade', 'title': 'edit'}).text("*")
                                .click(function () {
                                    document.location.href = 'editPost?postId=' + post.post_id;
                                }))
                        .append($('<button>').attr({'class':'delete fade','title':'delete'}).text("X")
                                .click(function () {
                                    deletePost(post);
                                }))                        
                
                ));
    });
}

function clearPosts() {
    $("#post-list").empty();
}

function deletePost(post) {
    var answer = confirm('Do you really want to delete this post?');

    if (answer === true) {
        $.ajax({
            method: 'DELETE',
            url: 'api/posts/' + post.post_id
        }).success(function () {
            // reload summary
            loadPosts();
        });
    }
}  