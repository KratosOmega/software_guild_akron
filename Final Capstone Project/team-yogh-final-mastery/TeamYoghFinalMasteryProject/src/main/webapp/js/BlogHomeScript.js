$(document).ready(function(){
    loadPosts();
});

function loadPosts(){
    clearPosts();
    var settings = {
        "async":true,
        "crossDomain":true,
        "url":"http://localhost:8080/TeamYoghFinalMasteryProject/posts",
        "method":"GET",
        "headers":{
            "chache-control":"no-cache"
        }
    };
    $.ajax(settings).done(function(data,status){
        fillPostList(data,status);
    });
}

function fillPostList(posts,status){
    clearPosts();
    var postList = $("#postLister");
    
    $.each(posts,function(index,post){
        postList.append($('<div>').attr({'class':'post'})
                .append($('<div>').attr({'class':'post-title'}).text(post.post_title))
                /*.append($('<div>').attr({'class':'post-category'}).text(post.post_category))*/
                        .append($('<div>').attr({'class':'post-preview'}).html(post.post_content))
                        .append($('<div>').attr({'class':'post-read-more'}).text('READ MORE')
                        .click(function(){
                            document.location.href = 'blogPost?postId=' + post.post_id;
                   // document.location.href = 'blog_post';
        })));
    });
}

function clearPosts(){
    $("#postLister").empty();
}