
package com.sg.teamyoghfinalmasteryproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewPostController {
 
    @RequestMapping(value = "newPost", method = RequestMethod.GET)
    public String displayNewPost() {
        return "newPost";
    }       
    
}
