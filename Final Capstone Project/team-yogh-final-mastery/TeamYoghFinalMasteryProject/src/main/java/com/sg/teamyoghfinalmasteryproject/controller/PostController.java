package com.sg.teamyoghfinalmasteryproject.controller;

import com.sg.teamyoghfinalmasteryproject.dao.BlogApi;
import com.sg.teamyoghfinalmasteryproject.model.Post;
import java.util.List;
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
public class PostController {
    private BlogApi dao;
    
    @Inject
    public PostController(BlogApi dao){
        this.dao = dao;
    }
    
    @RequestMapping(value = "editor", method = RequestMethod.GET)
    public String displayEditor() {
        return "siteEditorLandingPage";
    }   

    @RequestMapping(value = "newPage", method = RequestMethod.GET)
    public String displayNewPage() {
        return "newPage";
    }      

   @RequestMapping(value = "search", method = RequestMethod.GET)
    public String displaySearch() {
        return "search";
    }
    
   @RequestMapping(value = "editPost", method = RequestMethod.GET)
    public String displayEditPost() {
        return "editPost";
    }    
    
    @RequestMapping(value = "comments", method = RequestMethod.GET)
    public String displayComments() {
        return "comments";
    }   
    


    @RequestMapping(value="/api/posts/date/{date}", method = RequestMethod.GET)
    @ResponseBody public List<Post> getPostByDate(@PathVariable("date") String post_publish_date){
        return dao.listPostByPublishDate(post_publish_date);
    }      
 
    @RequestMapping(value="/api/tags/{name}/posts", method = RequestMethod.GET)
    @ResponseBody public List<Post> getPostByTag(@PathVariable("name") List<String> tag_nameList){
        return dao.listPostByTags(tag_nameList);
    }      
   
    @RequestMapping(value="/api/posts//title/{title}", method = RequestMethod.GET)
    @ResponseBody public Post getPostByTitle(@PathVariable("title") String post_title){
        return dao.listPostByTitle(post_title);
    }       
 
    @RequestMapping(value="/api/users/{name}/post", method = RequestMethod.GET)
    @ResponseBody public List<Post> getPostByAuthor(@PathVariable("name") String user_name){
        return dao.listPostByUser(user_name);
    }    
    
  
    
}
