
package com.sg.teamyoghfinalmasteryproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String displayUsers() {
        return "users";
    }
        
}
