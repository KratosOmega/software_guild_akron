package com.sg.teamyoghfinalmasteryproject.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.teamyoghfinalmasteryproject.dao.BlogApi;
import com.sg.teamyoghfinalmasteryproject.model.Page;
import com.sg.teamyoghfinalmasteryproject.model.Post;
import com.sg.teamyoghfinalmasteryproject.model.PostWithTags;
import com.sg.teamyoghfinalmasteryproject.model.Tag;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ApiController {

    private BlogApi dao;

    @Inject
    public ApiController(BlogApi dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "api/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPostById(@PathVariable("id") int post_id) {
        Map<String, Object> dataList = new HashMap<>();
        dataList.put("post", dao.listPostById(post_id));
        dataList.put("user", dao.listUserByPostId(post_id));
        dataList.put("status", dao.listStatusByPostId(post_id));
        dataList.put("category", dao.listCategoryByPostId(post_id));
        dataList.put("tags", dao.listTagByPostId(post_id));

        return dataList;
    }

    @RequestMapping(value = "api/posts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllPosts() {
        return dao.listAllPost();
    }

    @RequestMapping(value = "api/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PostWithTags createPost(@RequestBody String content) {
        ObjectMapper mapper = new ObjectMapper();
        Post post;
        Tag tag;

        try {
            JsonNode node = mapper.readTree(content);
            post = mapper.convertValue(node.get("post"), Post.class);
            tag = mapper.convertValue(node.get("tags"), Tag.class);
        } catch (IOException ex) {
            return null;
        }

        post = dao.addPost(post);
        PostWithTags postWithTags = new PostWithTags();
        postWithTags.setPost(post);
//        if (tag == null) {
        tag = dao.addTag(tag);
        dao.addTagToPost(post.getPost_id(), tag.getTag_id());
        postWithTags.setTag(tag);
        //       }
        return postWithTags;
    }

    @RequestMapping(value = "api/posts/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editPost(@PathVariable("id") int post_id, @RequestBody String content) {
        ObjectMapper mapper = new ObjectMapper();
        Post post = new Post();
        Tag tag = new Tag();

        try {
            JsonNode node = mapper.readTree(content);
            post = mapper.convertValue(node.get("post"), Post.class);
            tag = mapper.convertValue(node.get("tags"), Tag.class);

        } catch (IOException ex) {

        }
        post.setPost_id(post_id);

        dao.editPost(post);
        dao.editTag(tag);
    }

    @RequestMapping(value = "api/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") int post_id) {
        dao.removePost(post_id);
    }

    @RequestMapping(value = "api/pages", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Page createPage(@RequestBody String content) {
        ObjectMapper mapper = new ObjectMapper();
        Page page;

        try {
            JsonNode node = mapper.readTree(content);
            page = mapper.convertValue(node.get("page"), Page.class);
        } catch (IOException ex) {
            return null;
        }

        page = dao.addPage(page);

        return page;
    }

//   @RequestMapping(value = "api/posts/{id}/tags", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public Tag createPostwithTags(@RequestBody PostWithTags postWithTags) {
//        Tag tmpTag = new Tag();
//        tmpTag.equals(postWithTags.getTag());
//        return tmpTag;
//    }     
//    @RequestMapping(value = "api/posts", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public Post createPost(@RequestBody Post post) {
//
//        dao.addPost(post);
//        return post;
//    }    
}
