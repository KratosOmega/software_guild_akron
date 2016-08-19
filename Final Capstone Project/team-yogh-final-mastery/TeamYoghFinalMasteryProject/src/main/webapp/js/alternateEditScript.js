$("#topbar-brand").click(function(){
	document.location.href = 'editor';
});
$("#new-post").click(function(){
	document.location.href = 'newPost';
});
$(".user-new-post").click(function(){
    document.location.href='newPost';
});
$("#new-page").click(function(){
	document.location.href = 'newPage';
});
$("#users").click(function(){
	document.location.href = 'users';
});
$("#search").click(function(){
	document.location.href = 'search';
});
$("#delete-page").click(function(){
	document.location.href = 'search';
});

$(".post-title").click(function(){
    document.location.href = 'editPost';
});

/* POST BUTTONS */
$(".edit").click(function(){
    document.location.href = 'editPost';
});
$(".comments").click(function(){
   document.location.href = 'comments'; 
});




/* PAGES */




/* CKEDITOR */
$("#new-post-text").ckeditor({
	width:'100%'
});
/* TAGSINPUT */
$("#post-tags").tagsInput({
    'width':'80%',
    'defaultText':'',
    'color':'white'
});