/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.teamyoghfinalmasteryproject.dao;

import com.sg.teamyoghfinalmasteryproject.model.Comment;
import com.sg.teamyoghfinalmasteryproject.model.Page;
import com.sg.teamyoghfinalmasteryproject.model.Post;
import com.sg.teamyoghfinalmasteryproject.model.Tag;
import com.sg.teamyoghfinalmasteryproject.model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
/*public class BlogImplTest {

    private BlogApi dao;

    public BlogImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-spring-persistence.xml");
        dao = (BlogApi) ctx.getBean("BlogApi");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // Test Cases
    @Test
    public void add_select_edit_remove_Post_Test() {
        Post post = new Post();
        post.setPost_title("test");
        post.setPost_content("test");
        post.setPost_publish_date("2016-08-11");
        post.setPost_create_date("2016-08-11");
        post.setUser_id(1);
        post.setCategory_id(1);
        post.setStatus_id(1);

        Post expectedAdd = dao.addPost(post);
        Post actualAdd = dao.listPostById(expectedAdd.getPost_id());
        org.junit.Assert.assertEquals(expectedAdd.getPost_id(), actualAdd.getPost_id());
        org.junit.Assert.assertEquals(expectedAdd.getPost_title(), actualAdd.getPost_title());
        org.junit.Assert.assertEquals(expectedAdd.getPost_content(), actualAdd.getPost_content());
        org.junit.Assert.assertEquals(expectedAdd.getPost_publish_date(), actualAdd.getPost_publish_date());
        org.junit.Assert.assertEquals(expectedAdd.getPost_create_date(), actualAdd.getPost_create_date());
        org.junit.Assert.assertEquals(expectedAdd.getUser_id(), actualAdd.getUser_id());
        org.junit.Assert.assertEquals(expectedAdd.getCategory_id(), actualAdd.getCategory_id());
        org.junit.Assert.assertEquals(expectedAdd.getStatus_id(), actualAdd.getStatus_id());

        Post editedPost = post;
        editedPost.setPost_title("new test");
        editedPost.setPost_content("new test");
        editedPost.setPost_publish_date("1990-03-05");
        editedPost.setPost_create_date("1990-03-05");
        editedPost.setUser_id(2);
        editedPost.setCategory_id(2);
        editedPost.setStatus_id(2);

        Post expectedEdited = editedPost;
        dao.editPost(editedPost);
        Post actualEdited = dao.listPostById(editedPost.getPost_id());
        org.junit.Assert.assertEquals(expectedEdited.getPost_id(), actualEdited.getPost_id());
        org.junit.Assert.assertEquals(expectedEdited.getPost_title(), actualEdited.getPost_title());
        org.junit.Assert.assertEquals(expectedEdited.getPost_content(), actualEdited.getPost_content());
        org.junit.Assert.assertEquals(expectedEdited.getPost_publish_date(), actualEdited.getPost_publish_date());
        org.junit.Assert.assertEquals(expectedEdited.getPost_create_date(), actualEdited.getPost_create_date());
        org.junit.Assert.assertEquals(expectedEdited.getUser_id(), actualEdited.getUser_id());
        org.junit.Assert.assertEquals(expectedEdited.getCategory_id(), actualEdited.getCategory_id());
        org.junit.Assert.assertEquals(expectedEdited.getStatus_id(), actualEdited.getStatus_id());

        dao.removePost(editedPost.getPost_id());
        org.junit.Assert.assertNull(dao.listPostById(editedPost.getPost_id()));
    }

    @Test
    public void add_select_edit_remove_Tag_Test() {
        Tag tag = new Tag();
        tag.setTag_name("TestTag");

        Tag expectedAdd = dao.addTag(tag);
        Tag actualAdd = dao.listTagById(expectedAdd.getTag_id());
        org.junit.Assert.assertEquals(expectedAdd.getTag_id(), actualAdd.getTag_id());
        org.junit.Assert.assertEquals(expectedAdd.getTag_name(), actualAdd.getTag_name());

        Tag editedTag = tag;
        editedTag.setTag_name("EditedTag");
        dao.editTag(editedTag);

        Tag expectedEdit = editedTag;
        Tag actualEdit = dao.listTagById(editedTag.getTag_id());
        org.junit.Assert.assertEquals(expectedEdit.getTag_id(), actualEdit.getTag_id());
        org.junit.Assert.assertEquals(expectedEdit.getTag_name(), actualEdit.getTag_name());

        dao.removeTag(tag.getTag_id());
        org.junit.Assert.assertNull(dao.listTagById(tag.getTag_id()));
    }


    @Test
    public void add_select_edit_remove_user_Test() {
        User user = new User();
        user.setUser_name("Clarice");
        user.setUser_password("clarice123");
        user.setUser_enabled(1);

        User expectedAdd = dao.addUser(user);
        User actualAdd = dao.listUserById(expectedAdd.getUser_id());
        org.junit.Assert.assertEquals(expectedAdd.getUser_id(), actualAdd.getUser_id());
        org.junit.Assert.assertEquals(expectedAdd.getUser_name(), actualAdd.getUser_name());
        org.junit.Assert.assertEquals(expectedAdd.getUser_password(), actualAdd.getUser_password());
        org.junit.Assert.assertEquals(expectedAdd.getUser_enabled(), actualAdd.getUser_enabled());

        User editedUser = user;
        editedUser.setUser_name("Cui");
        editedUser.setUser_password("Cui@gmail.com");
        editedUser.setUser_enabled(2);
        dao.editUser(editedUser);

        User expectedEdit = editedUser;
        User actualEdit = dao.listUserById(expectedEdit.getUser_id());
        org.junit.Assert.assertEquals(expectedEdit.getUser_id(), actualEdit.getUser_id());
        org.junit.Assert.assertEquals(expectedEdit.getUser_name(), actualEdit.getUser_name());
        org.junit.Assert.assertEquals(expectedEdit.getUser_password(), actualEdit.getUser_password());
        org.junit.Assert.assertEquals(expectedEdit.getUser_enabled(), actualEdit.getUser_enabled());

        dao.removeUser(user.getUser_id());
        org.junit.Assert.assertNull(dao.listUserById(user.getUser_id()));
    }

    @Test
    public void add_select_edit_remove_page_Test() {
        Page page = new Page();
        page.setPage_tab("testTab");
        page.setPage_content("testContent");
        page.setStatus_id(1);

        Page expectedAdd = dao.addPage(page);
        Page actualAdd = dao.listPageById(expectedAdd.getPage_id());

        org.junit.Assert.assertEquals(expectedAdd.getPage_id(), actualAdd.getPage_id());
        org.junit.Assert.assertEquals(expectedAdd.getPage_tab(), actualAdd.getPage_tab());
        org.junit.Assert.assertEquals(expectedAdd.getPage_content(), actualAdd.getPage_content());
        org.junit.Assert.assertEquals(expectedAdd.getStatus_id(), actualAdd.getStatus_id());

        
        Page editedPage = page;
        editedPage.setPage_tab("EditedTab");
        editedPage.setPage_content("EditedContent");
        editedPage.setStatus_id(2);
        dao.editPage(editedPage);

        
        Page expectedEdit = editedPage;
        Page actualEdit = dao.listPageById(expectedEdit.getPage_id());
        org.junit.Assert.assertEquals(expectedEdit.getPage_id(), actualEdit.getPage_id());
        org.junit.Assert.assertEquals(expectedEdit.getPage_tab(), actualEdit.getPage_tab());
        org.junit.Assert.assertEquals(expectedEdit.getPage_content(), actualEdit.getPage_content());
        org.junit.Assert.assertEquals(expectedEdit.getStatus_id(), actualEdit.getStatus_id());

        dao.removePage(page.getPage_id());
        org.junit.Assert.assertNull(dao.listPageById(page.getPage_id()));
    }
 
}
*/