/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.teamyoghfinalmasteryproject.controller;

import com.sg.teamyoghfinalmasteryproject.dao.BlogApi;

import com.sg.teamyoghfinalmasteryproject.model.Post;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Owner
 */
@Controller
public class BlogArchiveController {

    private BlogApi dao;

    @Inject
    public BlogArchiveController(BlogApi dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "archive", method = RequestMethod.GET)
    public String displayBlogPostPage() {
        return "blogArchive";
    }

    @RequestMapping(value = "archive/posts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllPosts() {
        return dao.listAllPost();
    }
}
