/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.teamyoghfinalmasteryproject.dao;

import com.sg.teamyoghfinalmasteryproject.model.Category;
import com.sg.teamyoghfinalmasteryproject.model.Comment;
import com.sg.teamyoghfinalmasteryproject.model.Page;
import com.sg.teamyoghfinalmasteryproject.model.Post;
import com.sg.teamyoghfinalmasteryproject.model.Status;
import com.sg.teamyoghfinalmasteryproject.model.Tag;
import com.sg.teamyoghfinalmasteryproject.model.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kratos
 */
public interface BlogApi {

    // post
    public Post addPost(Post post);

    public void editPost(Post post);

    public void removePost(int post_id);

    public List<Post> listAllPost();

    public Post listPostById(int post_id);

    public User listUserByPostId(int post_id);

    public Status listStatusByPostId(int post_id);

    public Category listCategoryByPostId(int post_id);

    public Post listPostByTitle(String post_title);

    public List<Post> listPostByUser(String user_name);

    public List<Post> listPostByTags(List<String> tag_nameList);

    public List<Post> listPostByCreateDate(String post_create_date);

    public List<Post> listPostByPublishDate(String post_publish_date);

    public List<Post> listPostByPublishStatus();

    public List<Post> listPostByDraftStatus();

    public List<Post> listPostByScheduleStatus();

    public List<Post> listPostByArchiveStatus();

    public void editPublishPost(Post post);

    public void editDraftPost(Post post);

    public void editSchedulePost(Post post);

    public void editArchivePost(Post post);

    // tag
    public void addTagToPost(int post_id, int tag_id);

    public Tag addTag(Tag tag);

    public void editTag(Tag tag);

    public void removeTag(int tag_id);

    public List<Tag> listAllTag();

    public Tag listTagById(int tag_id);

    public List<Tag> listTagByPostId(int post_id);

    // comment
    public Comment addComment(Comment comment);

    public void editComment(Comment comment);

    public void removeComment(int comment_id);

    public List<Comment> listAllComment();

    public List<Comment> listAllCommentByPost(int post_id);

    public Comment listCommentById(int comment_id);

    // user
    public User addUser(User user);

    public void editUser(User user);

    public void removeUser(int user_id);

    public List<User> listAllUser();

    public User listUserById(int user_id);

    // status (status should be predefined in the database and rarely changed)
    // page
    public Page addPage(Page page);

    public void editPage(Page page);

    public void removePage(int page_id);

    public List<Page> listAllPages();

    public Page listPageById(int page_id);

}
