$("#topbar-brand").click(function(){
	document.location.href = 'alternateEditPage1.html';
});
$("#new-post").click(function(){
	document.location.href = 'newPost.html';
});
$("#new-page").click(function(){
	document.location.href = 'newPage.html';
});
$("#users").click(function(){
	document.location.href = 'users.html';
});
$("#search").click(function(){
	document.location.href = 'search.html';
});

/* CKEDITOR */
$("#new-post-text").ckeditor({
	width:'80%'
});
/* TAGSINPUT */
$("#post-tags").tagsInput();