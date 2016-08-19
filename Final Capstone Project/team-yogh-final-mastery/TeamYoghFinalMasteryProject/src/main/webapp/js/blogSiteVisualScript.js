

/* blur background when scrolling */
$(window).scroll(function(){
    var scroll = $(window).scrollTop(),
    opacity = (scroll/600.0);
    $('#blurred').css('opacity',opacity);
});

/* links */
$("#site-title").click(function(){
    document.location.href = '';
});
$("#archive-link").click(function(){
    document.location.href='archive';
});
$(".blog-name-header").click(function(){
    document.location.href = '';
});
//$(".post-read-more").click(function(){
//    document.location.href = 'blog_post';
//});

/* static pages links */
$(".other-pages-link").click(function(){
    document.location.href='page';
});
$(".pages-link").click(function(){
    document.location.href='page';
});