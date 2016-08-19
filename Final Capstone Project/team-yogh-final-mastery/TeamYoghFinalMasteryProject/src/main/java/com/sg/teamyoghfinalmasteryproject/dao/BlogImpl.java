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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kratos
 */
public class BlogImpl implements BlogApi {

    private JdbcTemplate jdbcTemplate;

    // DI by using setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SQL Statements
    // Last inserted ID
    private static final String SQL_SELECT_LAST_INSERTED_ID = "SELECT LAST_INSERT_ID() ";

    // post
    private static final String SQL_INSERT_POST = "INSERT INTO blog_post(post_title, post_content, post_publish_date, post_create_date, user_id, category_id, status_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_POST = "DELETE FROM blog_post WHERE post_id = ?";
    private static final String SQL_UPDATE_POST = "UPDATE blog_post SET post_title = ?, post_content = ?, post_publish_date = ?, post_create_date = ?, user_id = ?, category_id = ?, status_id = ? WHERE post_id = ?";
    private static final String SQL_PUBLISH_POST = "UPDATE blog_post SET status_id = 1 WHERE post_id = ?";
    private static final String SQL_DRAFT_POST = "UPDATE blog_post SET status_id = 2 WHERE post_id = ?";
    private static final String SQL_SCHEDULE_POST = "UPDATE blog_post SET status_id = 3 WHERE post_id = ?";
    private static final String SQL_ARCHIVE_POST = "UPDATE blog_post SET status_id = 4 WHERE post_id = ?";
    // I probably need to remove teh DELETE status, cuz delete is delete, record is removed complete from database, no need to have delete status

    // ***************************************** Ignore the JOIN table situatio -> make the simple post work first 
    // HOW to deal with 1 post - multiple tags?
    private static final String SQL_SELECT_POST
            = "SELECT post_id, post_title, post_content, post_publish_date, post_create_date, user_id, category_id, status_id "
            + "FROM blog_post";
    private static final String SQL_SELECT_POST_BY_POST_ID
            = "SELECT "
            + "bp.post_id, bp.post_title, bp.post_content, bp.post_publish_date, bp.post_create_date, bp.user_id, bp.category_id, bp.status_id, "
            + "bu.user_id, bu.user_name, bu.user_password, bu.user_enabled, "
            + "bc.category_id, bc.category_name, "
            + "bs.status_id, bs.status_name "
            + "FROM blog_post AS bp, blog_user AS bu, blog_category AS bc, blog_status AS bs "
            + "WHERE bp.user_id = bu.user_id AND bp.category_id = bc.category_id AND bp.status_id = bs.status_id AND bp.post_id = ?";

    // ----------------------------------------- Below needs to be updated!!!
    private static final String SQL_SELECT_POST_BY_POST_TITLE
            = "SELECT * "
            + "FROM blog_post AS bp, blog_user AS bu, blog_category AS bc, blog_status AS bs "
            + "WHERE bp.user_id = bu.user_id AND bp.category_id = bc.category_id AND bp.status_id = bs.status_id AND bp.post_title = ?";

    private static final String SQL_SELECT_POST_BY_POST_USER
            = "SELECT * "
            + "FROM blog_post AS bp, blog_user AS bu, blog_category AS bc, blog_status AS bs "
            + "WHERE bp.user_id = bu.user_id AND bp.category_id = bc.category_id AND bp.status_id = bs.status_id AND bu.user_name = ?";

    private static final String SQL_SELECT_POST_BY_POST_Tag
            = "SELECT * "
            + "FROM blog_post AS bp, blog_user AS bu, blog_category AS bc, blog_status AS bs "
            + "INNER JOIN blog_post_to_tag AS bptt "
            + "ON bp.post_id = bptt.post_id "
            + "INNER JOIN blog_tag AS bt "
            + "ON bptt.tag_id = bt.tag_id "
            + "WHERE bp.user_id = bu.user_id AND bp.category_id = bc.category_id AND bp.status_id = bs.status_id ";

    private static final String SQL_SELECT_POST_BY_POST_CREATE_DATE
            = "SELECT *"
            + "FROM blog_post AS bp, blog_user AS bu, blog_category AS bc, blog_status AS bs "
            + "WHERE bp.user_id = bu.user_id AND bp.category_id = bc.category_id AND bp.status_id = bs.status_id AND bp.post_create_date = ?";

    private static final String SQL_SELECT_POST_BY_POST_PUBLISH_DATE
            = "SELECT * "
            + "FROM blog_post AS bp, blog_user AS bu, blog_category AS bc, blog_status AS bs "
            + "WHERE bp.user_id = bu.user_id AND bp.category_id = bc.category_id AND bp.status_id = bs.status_id AND bp.post_publish_date = ?";

    // ------
    private static final String SQL_SELECT_POST_BY_STATUS
            = "SELECT * "
            + "FROM blog_post AS bp "
            + "INNER JOIN blog_status AS bs "
            + "ON bp.status_id = bs.status_id "
            + "WHERE bs.status_id = ?";

    // comment
    private static final String SQL_INSERT_COMMENT = "INSERT INTO blog_comment(comment_content, comment_publish_date, user_id, post_id) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE_COMMENT = "DELETE FROM blog_comment WHERE comment_id = ?";
    private static final String SQL_UPDATE_COMMENT = "UPDATE blog_comment SET comment_content = ?, comment_publish_date = ?, user_id = ?, post_id = ? WHERE comment_id = ?";
    private static final String SQL_SELECT_COMMENT = "SELECT * FROM blog_comment";
    private static final String SQL_SELECT_COMMENT_BY_COMMENT_ID = "SELECT * FROM blog_comment WHERE comment_id = ?";
    private static final String SQL_SELECT_COMMENT_BY_POST
            = "SELECT * "
            + "FROM blog_post AS bp, blog_comment AS bc "
            + "WHERE bp.post_id = bc.post_id AND bc.post_id = ?";

    // user
    private static final String SQL_INSERT_USER = "INSERT INTO blog_user(user_name, user_password, user_enabled) VALUES (?, ?, ?)";
    private static final String SQL_DELETE_USER = "DELETE FROM blog_user WHERE user_id = ?";
    private static final String SQL_UPDATE_USER = "UPDATE blog_user SET user_name = ?, user_password = ?, user_enabled = ? WHERE user_id = ?";

    private static final String SQL_SELECT_USER = "SELECT user_id, user_name, user_password, user_enabled FROM blog_user";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT user_id, user_name, user_password, user_enabled FROM blog_user WHERE user_id = ?";
    // category
    // tag
    private static final String SQL_INSERT_TAG = "INSERT INTO blog_tag(tag_name) VALUES (?)";
    private static final String SQL_DELETE_TAG = "DELETE FROM blog_tag WHERE tag_id = ?";
    private static final String SQL_UPDATE_TAG = "UPDATE blog_tag SET tag_name = ? WHERE tag_id = ?";

    private static final String SQL_SELECT_TAG = "SELECT * FROM blog_tag";
    private static final String SQL_SELECT_TAG_BY_ID = "SELECT * FROM blog_tag WHERE tag_id = ?";
    private static final String SQL_SELECT_TAG_BY_POST_ID
            = "select bt.* from blog_tag bt "
            + "inner join blog_post_to_tag b "
            + "on bt.tag_id = b.tag_id "
            + "where b.post_id  = ? ";

    private static final String SQL_INSERT_TAG_TO_POST = "INSERT INTO blog_post_to_tag (post_id, tag_id) values (?,?)";

    //page
    private static final String SQL_INSERT_PAGE
            = "INSERT INTO blog_page(page_tab, page_content, status_id) VALUES (?, ?, ?)";
    private static final String SQL_DELETE_PAGE
            = "DELETE FROM blog_page WHERE page_id = ?";
    private static final String SQL_UPDATE_PAGE
            = "UPDATE blog_page SET page_tab = ?, page_content = ?, status_id = ? WHERE page_id = ?";

    private static final String SQL_SELECT_PAGE
            = "SELECT bp.page_id, bp.page_tab, bp.page_content, bp.status_id, bs.status_name "
            + "FROM blog_page AS bp, blog_status AS bs "
            + "WHERE bp.status_id = bs.status_id";
    private static final String SQL_SELECT_PAGE_BY_PAGE_ID
            = "SELECT bp.page_id, bp.page_tab, bp.page_content, bp.status_id, bs.status_name "
            + "FROM blog_page AS bp, blog_status AS bs "
            + "WHERE bp.status_id = bs.status_id AND bp.page_id = ?";

    // status
    // post_to_tag
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post addPost(Post post) {
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getPost_title(),
                post.getPost_content(),
                post.getPost_publish_date(),
                post.getPost_create_date(),
                post.getUser_id(),
                post.getCategory_id(),
                post.getStatus_id());
        post.setPost_id(jdbcTemplate.queryForObject(SQL_SELECT_LAST_INSERTED_ID, Integer.class));
        return post;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void addTagToPost(int post_id, int tag_id) {
        jdbcTemplate.update(SQL_INSERT_TAG_TO_POST,
                post_id, tag_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editPost(Post post) {
        jdbcTemplate.update(SQL_UPDATE_POST,
                post.getPost_title(),
                post.getPost_content(),
                post.getPost_publish_date(),
                post.getPost_create_date(),
                post.getUser_id(),
                post.getCategory_id(),
                post.getStatus_id(),
                post.getPost_id());
    }

    @Override
    public void editPublishPost(Post post) {
        jdbcTemplate.update(SQL_PUBLISH_POST, post.getPost_id());
    }

    @Override
    public void editDraftPost(Post post) {
        jdbcTemplate.update(SQL_DRAFT_POST, post.getPost_id());
    }

    @Override
    public void editSchedulePost(Post post) {
        jdbcTemplate.update(SQL_SCHEDULE_POST, post.getPost_id());
    }

    @Override
    public void editArchivePost(Post post) {
        jdbcTemplate.update(SQL_ARCHIVE_POST, post.getPost_id());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removePost(int id) {
        jdbcTemplate.update(SQL_DELETE_POST, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listAllPost() {
        return jdbcTemplate.query(SQL_SELECT_POST, new PostMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post listPostById(int post_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST_BY_POST_ID, new PostMapper(), post_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User listUserByPostId(int post_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST_BY_POST_ID, new UserMapper(), post_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Status listStatusByPostId(int post_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST_BY_POST_ID, new StatusMapper(), post_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Category listCategoryByPostId(int post_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST_BY_POST_ID, new CategoryMapper(), post_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post listPostByTitle(String post_title) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST_BY_POST_TITLE, new PostMapper(), post_title);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listPostByUser(String user_name) {
        return jdbcTemplate.query(SQL_SELECT_POST_BY_POST_USER, new PostMapper(), user_name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listPostByTags(List<String> tag_nameList) {
        int tag_num = tag_nameList.size();
        String[] tag_params = new String[tag_num];

        String SQL_SELECT_POST_BY_POST_Tags = SQL_SELECT_POST_BY_POST_Tag;

        for (int i = 0; i < tag_num; i++) {
            tag_params[i] = tag_nameList.get(i);
            SQL_SELECT_POST_BY_POST_Tags += "AND bt.tag_name = ? ";
        }

        return jdbcTemplate.query(SQL_SELECT_POST_BY_POST_Tags, tag_params, new PostMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listPostByCreateDate(String post_create_date) {
        return jdbcTemplate.query(SQL_SELECT_POST_BY_POST_CREATE_DATE, new PostMapper(), post_create_date);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listPostByPublishDate(String post_publish_date) {
        return jdbcTemplate.query(SQL_SELECT_POST_BY_POST_PUBLISH_DATE, new PostMapper(), post_publish_date);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listPostByPublishStatus() {
        return jdbcTemplate.query(SQL_SELECT_POST_BY_STATUS, new PostMapper(), 1);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listPostByDraftStatus() {
        return jdbcTemplate.query(SQL_SELECT_POST_BY_STATUS, new PostMapper(), 2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listPostByScheduleStatus() {
        return jdbcTemplate.query(SQL_SELECT_POST_BY_STATUS, new PostMapper(), 3);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Post> listPostByArchiveStatus() {
        return jdbcTemplate.query(SQL_SELECT_POST_BY_STATUS, new PostMapper(), 4);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Tag addTag(Tag tag) {
        jdbcTemplate.update(SQL_INSERT_TAG, tag.getTag_name());
        tag.setTag_id(jdbcTemplate.queryForObject(SQL_SELECT_LAST_INSERTED_ID, Integer.class));
        return tag;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editTag(Tag tag) {
        jdbcTemplate.update(SQL_UPDATE_TAG,
                tag.getTag_name(),
                tag.getTag_id());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeTag(int tag_id) {
        jdbcTemplate.update(SQL_DELETE_TAG, tag_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Tag> listAllTag() {
        return jdbcTemplate.query(SQL_SELECT_TAG, new TagMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Tag listTagById(int tag_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_TAG_BY_ID, new TagMapper(), tag_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Tag> listTagByPostId(int post_id) {
        return jdbcTemplate.query(SQL_SELECT_TAG_BY_POST_ID, new TagMapper(), post_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Comment addComment(Comment comment) {
        jdbcTemplate.update(SQL_INSERT_COMMENT,
                comment.getComment_content(),
                comment.getComment_publish_date(),
                comment.getUser_id(),
                comment.getPost_id());
        comment.setComment_id(jdbcTemplate.queryForObject(SQL_SELECT_LAST_INSERTED_ID, Integer.class));

        return comment;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editComment(Comment comment) {
        jdbcTemplate.update(SQL_UPDATE_COMMENT,
                comment.getComment_content(),
                comment.getComment_publish_date(),
                comment.getUser_id(),
                comment.getPost_id(),
                comment.getComment_id());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeComment(int comment_id) {
        jdbcTemplate.update(SQL_DELETE_COMMENT, comment_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Comment> listAllComment() {
        return jdbcTemplate.query(SQL_SELECT_COMMENT, new CommentMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Comment> listAllCommentByPost(int post_id) {
        return jdbcTemplate.query(SQL_SELECT_COMMENT_BY_POST, new CommentMapper(), post_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Comment listCommentById(int comment_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_COMMENT_BY_COMMENT_ID, new CommentMapper(), comment_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User addUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
                user.getUser_name(),
                user.getUser_password(),
                user.getUser_enabled());
        user.setUser_id(jdbcTemplate.queryForObject(SQL_SELECT_LAST_INSERTED_ID, Integer.class));

        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                user.getUser_name(),
                user.getUser_password(),
                user.getUser_enabled(),
                user.getUser_id());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeUser(int user_id) {
        jdbcTemplate.update(SQL_DELETE_USER, user_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<User> listAllUser() {
        return jdbcTemplate.query(SQL_SELECT_USER, new UserMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User listUserById(int user_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID, new UserMapper(), user_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Page addPage(Page page) {
        jdbcTemplate.update(SQL_INSERT_PAGE,
                page.getPage_tab(),
                page.getPage_content(),
                page.getStatus_id());
        page.setPage_id(jdbcTemplate.queryForObject(SQL_SELECT_LAST_INSERTED_ID, Integer.class));

        return page;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editPage(Page page) {
        jdbcTemplate.update(SQL_UPDATE_PAGE,
                page.getPage_tab(),
                page.getPage_content(),
                page.getStatus_id(),
                page.getPage_id());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removePage(int page_id) {
        jdbcTemplate.update(SQL_DELETE_PAGE, page_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Page> listAllPages() {
        return jdbcTemplate.query(SQL_SELECT_PAGE, new PageMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Page listPageById(int page_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PAGE_BY_PAGE_ID, new PageMapper(), page_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    // --------- Mapper
    private static final class PostMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post post = new Post();
            post.setPost_id(rs.getInt("post_id"));
            post.setPost_title(rs.getString("post_title"));
            post.setPost_content(rs.getString("post_content"));
            post.setPost_publish_date(rs.getString("post_publish_date"));
            post.setPost_create_date(rs.getString("post_create_date"));
            post.setUser_id(rs.getInt("user_id"));
            post.setCategory_id(rs.getInt("category_id"));
            post.setStatus_id(rs.getInt("status_id"));

            return post;
        }
    }

    private static final class TagMapper implements RowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag tag = new Tag();
            tag.setTag_id(rs.getInt("tag_id"));
            tag.setTag_name(rs.getString("tag_name"));

            return tag;
        }
    }

    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setUser_name(rs.getString("user_name"));
            user.setUser_password(rs.getString("user_password"));
            user.setUser_enabled(rs.getInt("user_enabled"));

            return user;
        }
    }

    private static final class CommentMapper implements RowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            Comment comment = new Comment();
            comment.setComment_id(rs.getInt("comment_id"));
            comment.setComment_content(rs.getString("comment_content"));
            comment.setComment_publish_date(rs.getString("comment_publish_date"));
            comment.setUser_id(rs.getInt("user_id"));
            comment.setPost_id(rs.getInt("post_id"));

            return comment;
        }
    }

    private static final class CategoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();
            category.setCategory_id(rs.getInt("category_id"));
            category.setCategory_name(rs.getString("category_name"));

            return category;
        }

    }

    private static final class StatusMapper implements RowMapper<Status> {

        @Override
        public Status mapRow(ResultSet rs, int i) throws SQLException {
            Status status = new Status();
            status.setStatus_id(rs.getInt("status_id"));
            status.setStatus_name(rs.getString("status_name"));

            return status;
        }
    }

    private static final class PageMapper implements RowMapper<Page> {

        @Override
        public Page mapRow(ResultSet rs, int i) throws SQLException {
            Page page = new Page();
            page.setPage_id(rs.getInt("page_id"));
            page.setPage_tab(rs.getString("page_tab"));
            page.setPage_content(rs.getString("page_content"));
            page.setStatus_id(rs.getInt("status_id"));

            return page;
        }

    }

}
