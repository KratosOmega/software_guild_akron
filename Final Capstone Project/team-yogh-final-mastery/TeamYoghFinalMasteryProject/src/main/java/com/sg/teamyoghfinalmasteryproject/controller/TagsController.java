/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.teamyoghfinalmasteryproject.controller;

import com.sg.teamyoghfinalmasteryproject.model.Post;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class TagsController {
  /*  
    private TagsApi dao;
    
    @Inject
    public TagsController(TagsApi dao){
        this.dao = dao;
    }    
    
    @RequestMapping(value = "/api/tags", method = RequestMethod.GET)
    @ResponseBody public List<Post> getAllTags(){
        return dao.listAllTags();
    }    

    @RequestMapping(value="/api/tags/{id}", method = RequestMethod.GET)
    @ResponseBody public Tag getTagById(@PathVariable("id") int tag_id){
        return dao.listTagById(tag_id);
    }    */
}
